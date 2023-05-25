package com.ecommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[id='userEmail']")
    private WebElement txtUserEmail;

    @FindBy(css = "[id='userPassword']")
    private WebElement txtPassword;

    @FindBy(css = "input[value='Login']")
    private WebElement btnLogin;

    public void loginIntoApplication(String email,String password){
        txtUserEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }
}
