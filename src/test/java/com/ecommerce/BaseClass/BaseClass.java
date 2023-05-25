package com.ecommerce.BaseClass;

import com.ecommerce.Utilities.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    public static ReadProperties readProperties = new ReadProperties();

    String appURL = readProperties.getBaseURL();
    String browserName = readProperties.getBrowserName();
    public static WebDriver driver;

    @BeforeClass
    public void openApplication(){
        if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(appURL);
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
