package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    By searchedItem = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5");
    By addToChartButton = By.xpath("//*[@id=\"add_to_cart\"]/button");
    By proceedToCheckoutButton = By.xpath("//span[normalize-space()='Proceed to checkout']");
    By searchResultField = By.cssSelector(".heading-counter");
    
    public void clickSearchedItem() throws InterruptedException {
        driver.findElement(searchedItem).click();
        Thread.sleep(7000);
    }

    public void clickAddToChartButton() throws InterruptedException {
        driver.findElement(addToChartButton).click();
        Thread.sleep(2000);
    }
    
    public void clickProceedToCheckoutButton() throws InterruptedException{
        driver.findElement(proceedToCheckoutButton).click();
        Thread.sleep(4000);
    }
    public boolean getTextSearchResults() {
            return driver.findElement(searchResultField).getText().contains("been found.");
        }
}
