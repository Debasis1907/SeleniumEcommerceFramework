package com.ecommerce.Utilities;

import com.ecommerce.BaseClass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusuableFunctions extends BaseClass {

    public static void scrollToElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public static void waitForElement(WebDriver driver,WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String getTitle(){
        return driver.getTitle();
    }

    public static String getURL(){
        return driver.getCurrentUrl();
    }

    public static void selectByText(WebElement element,String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public static void selectByValue(WebElement element,String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectByIndex(WebElement element,int value){
        Select select = new Select(element);
        select.selectByIndex(value);
    }
}
