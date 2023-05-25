package com.ecommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[normalize-space()='HOME']")
    private WebElement linkHome;

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    private WebElement linkOrders;
    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    private WebElement linkCart;

    @FindBy(xpath = "//button[contains(text(),'View')]")
    private WebElement btnViewProduct;

    @FindBy(xpath = "//button[normalize-space()='Sign Out']")
    private WebElement linkSignOut;

    public void clickOnViewProduct(){
        btnViewProduct.click();
    }

    public void clickOnCart(){
        linkCart.click();
    }

    public void clickOnSignOut(){
        linkSignOut.click();
    }
}
