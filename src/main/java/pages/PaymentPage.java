package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    By payByBankWireButton = By.xpath("//a[@title='Pay by bank wire']");
    By payByCheck = By.xpath("//a[@title='Pay by check.']");
    By confirmOrderButton = By.xpath("//span[normalize-space()='I confirm my order']");
    By orderAlertField = By.xpath("//p[@class='alert alert-success']");

    public void clickPayByBankWireButton() {
        driver.findElement(payByBankWireButton).click();
    }
    public void clickPayByCheck(){
        driver.findElement(payByCheck).click();
    }
    
    public void clickComfirmMyOrderButton(){
        driver.findElement(confirmOrderButton).click();
    }
    
    public boolean getOrderCompleteText() {
            return driver.findElement(orderAlertField).getText().contains("is complete");
        }
    
}   
