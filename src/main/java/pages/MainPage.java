package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Base {
    WebDriver driver;

    public MainPage (WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(this.driver,this);
        }
    By signInButton = By.cssSelector("a[title='Log in to your customer account']");
    
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
        
}
