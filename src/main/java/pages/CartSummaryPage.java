package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryPage {
    WebDriver driver;

    public CartSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    By proceedToCheckoutButton = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]");

    public void clickProceedToCheckoutButton() throws InterruptedException {
        driver.findElement(proceedToCheckoutButton).click();
        Thread.sleep(2000);
    }

}
