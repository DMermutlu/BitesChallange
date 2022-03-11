package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
    WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    By emailField = By.id("email");
    By passwordField = By.id("passwd");
    By submitLoginButton = By.id("SubmitLogin");
    By loginFailErrorMessage = By.xpath("//li[normalize-space()='Authentication failed.']");
    By loginFailInvalidMailAddressMessage = By.xpath("//li[normalize-space()='Invalid email address.']");

    public void setMail(String mail) {
        driver.findElement(emailField).sendKeys(mail);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmitLoginButton() throws InterruptedException {
        driver.findElement(submitLoginButton).click();
        Thread.sleep(3000);
    }

    public boolean getLoginFailErrorMessage() {
        return driver.findElement(loginFailErrorMessage).getText().contains("Authentication failed");
    }

    public boolean getLoginInvalidMailAddressMessage() {
        return driver.findElement(loginFailInvalidMailAddressMessage).getText().contains("Invalid email address");
    }
}   
