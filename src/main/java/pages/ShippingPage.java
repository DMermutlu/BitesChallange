package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
    WebDriver driver;

    public ShippingPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    By proceedToCheckOutButton = By.name("processCarrier");
    By termsOfServiceCheckbox = By.id("cgv");

    public void clickProceedToCheckOutButton(){
        driver.findElement(proceedToCheckOutButton).click();
    }

    public void clickTermsOfServiceCheckbox(){
        driver.findElement(termsOfServiceCheckbox).click();
    }

}