package com.ecommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    public void clickOnAddToCart(){
        addToCart.click();
    }
}
