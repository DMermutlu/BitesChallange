import base.Base;
import jdk.jfr.Description;
import onTestFailScreenShot.CustomListener;
import org.testng.annotations.*;
import pages.*;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

@Listeners(CustomListener.class)
public class Cases extends Base {
    MainPage mainPage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    ProductPage productPage;
    CartSummaryPage cartSummaryPage;
    AddressesPage addressesPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;


    public void setBrowser(String browserName) throws InterruptedException {
        super.setBrowser(browserName);
    }

    @BeforeMethod
    @Description("testin hangi browserda koşulması isteniyorsa browser name set edilmelidir")
    void setUp() throws InterruptedException {
        /**GoogleChrome için chrome, MozillaFirefox için firefox**/
        String browserName = "chrome";
        setBrowser(browserName);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Parameters({"u", "p"})
    void loginSuccessCase(String userName, String password) throws InterruptedException {
        mainPage = new MainPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        myAccountPage = new MyAccountPage(driver);

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        String username = "biteschallenge@yopmail.com";
//        String password = "!Q2w3e4r";

        mainPage.clickSignInButton();
        authenticationPage.setMail(userName);
        authenticationPage.setPassword(password);
        authenticationPage.clickSubmitLoginButton();
        Assert.assertTrue("main header is false", myAccountPage.getTextMainHeader());
    }

    @Test
    @Parameters({"u", "p"})
    void loginFailCaseInvalidCredentials(String userName, String password) throws InterruptedException {
        mainPage = new MainPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        myAccountPage = new MyAccountPage(driver);

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        String username = "biteschalle231nge@yopmail.com";
//        String password = "!Q2w3e4r";

        mainPage.clickSignInButton();
        authenticationPage.setMail(userName);
        authenticationPage.setPassword(password);
        authenticationPage.clickSubmitLoginButton();
        Assert.assertFalse("Authentication failed, either mail address or password is wrong ", authenticationPage.getLoginFailErrorMessage());

    }

    @Test
    @Parameters({"u", "p"})
    void loginFailCaseInvalidEmailAddress(String userName, String password) throws InterruptedException {
        mainPage = new MainPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        myAccountPage = new MyAccountPage(driver);

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        String username = "biteschalle231n";
//        String password = "!Q2w3e4r";

        mainPage.clickSignInButton();
        authenticationPage.setMail(userName);
        authenticationPage.setPassword(password);
        authenticationPage.clickSubmitLoginButton();
        Assert.assertFalse("Invalid email address", authenticationPage.getLoginInvalidMailAddressMessage());
    }

    @Test
    @Parameters({"u", "p", "item"})
    void happyPathScenario(String userName, String password, String searchItem) throws InterruptedException {
//        String username="biteschallenge@yopmail.com";
//        String password="!Q2w3e4r";
//        String searchItem="Printed Dress";
        mainPage = new MainPage(driver);
        authenticationPage = new AuthenticationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        productPage = new ProductPage(driver);
        cartSummaryPage = new CartSummaryPage(driver);
        addressesPage = new AddressesPage(driver);
        shippingPage = new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainPage.clickSignInButton();
        authenticationPage.setMail(userName);
        authenticationPage.setPassword(password);
        authenticationPage.clickSubmitLoginButton();
        Assert.assertTrue("main header is false", myAccountPage.getTextMainHeader());

        myAccountPage.searchViaSearchBar(searchItem);
        Assert.assertTrue("", productPage.getTextSearchResults());

        productPage.clickSearchedItem();
        productPage.clickAddToChartButton();
        productPage.clickProceedToCheckoutButton();
        cartSummaryPage.clickProceedToCheckoutButton();
        addressesPage.clickProceedToCheckOutButton();
        shippingPage.clickTermsOfServiceCheckbox();
        shippingPage.clickProceedToCheckOutButton();
        paymentPage.clickPayByCheck();
        paymentPage.clickComfirmMyOrderButton();
        Assert.assertTrue("Order not completed", paymentPage.getOrderCompleteText());
        Thread.sleep(10000);


    }
}
