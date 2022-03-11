package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    By pageHeader = By.id("center_column");
    By searchBar = By.id("search_query_top");
    By searchedItem = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5");
    By addToChartButton = By.xpath("//*[@id=\"add_to_cart\"]/button");

    public boolean getTextMainHeader() {

        return driver.findElement(pageHeader).getText().contains("MY ACCOUNT");
    }
    
    public void searchViaSearchBar(String searchedItem){
        driver.findElement(searchBar).click();
        Actions sendSearchedItem = new Actions(driver);
        sendSearchedItem.sendKeys(searchedItem).sendKeys(Keys.ENTER).perform();
    }
    

}
