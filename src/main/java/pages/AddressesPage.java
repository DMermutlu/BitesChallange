package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {
    WebDriver driver;

    public AddressesPage (WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(this.driver,this);
        }
    By proceedToCheckOutButton = By.name("processAddress");
    
    public void clickProceedToCheckOutButton() throws InterruptedException{
        driver.findElement(proceedToCheckOutButton).click();
        Thread.sleep(2000);
    }
        
}
