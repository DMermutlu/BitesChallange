package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;


    public void setBrowser(String browserName) throws InterruptedException {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
//                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//                capabilities.setCapability(ChromeOptions.CAPABILITY,options);
                driver = new ChromeDriver(options);
                driver.get("http://automationpractice.com/index.php");
                wait = new WebDriverWait(driver, 1000);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get("http://automationpractice.com/index.php");
                wait = new WebDriverWait(driver, 1000);
                break;
        }

    }

    public void failed(String testMethodName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("/Users/dogukanmermutlu/IdeaProjects/BitesChallenge/screenshots/"+testMethodName+"_failed"+".jpg"));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
