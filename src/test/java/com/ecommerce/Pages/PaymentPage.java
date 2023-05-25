package com.ecommerce.Pages;

import com.ecommerce.Utilities.ReusuableFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage {

    WebDriver driver;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[contains(text(),'Credit Card Number')]/following-sibling::input")
    private WebElement txtCreditCardNumber;

    @FindBy(xpath = "//div[contains(text(),'Name on Card ')]/following-sibling::input")
    private WebElement txtCardName;

    @FindBy(xpath = "//div[contains(text(),'CVV Code')]/following-sibling::input")
    private WebElement txtCVVNumber;

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    private WebElement selectCountry;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    private WebElement btnPlaceOrder;

    public PaymentPage enterPaymentDetails(String cardNumber, String cardName, String cvvNumber) throws InterruptedException {
        txtCreditCardNumber.clear();
        txtCreditCardNumber.sendKeys(cardNumber);
        txtCardName.sendKeys(cardName);
        txtCVVNumber.sendKeys(cvvNumber);
        selectCountry.sendKeys("Ind");
        List<WebElement> countries = driver.findElements(By.xpath("//button/span"));
        for(WebElement country : countries){
            System.out.println(country.getText());
            if(country.getText().equals("India")){
                country.click();
                break;
            }

        }
        return this;
    }

    public PaymentPage clickOnPlaceOrder(){
        btnPlaceOrder.click();
        return this;
    }
}
