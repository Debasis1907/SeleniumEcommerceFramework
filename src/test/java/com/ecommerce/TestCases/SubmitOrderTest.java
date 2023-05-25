package com.ecommerce.TestCases;

import com.ecommerce.BaseClass.BaseClass;
import com.ecommerce.Pages.*;
import com.ecommerce.Pojo.Payment;
import com.ecommerce.Utilities.ReusuableFunctions;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SubmitOrderTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;
    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;
    @Test
    public void purchaseOrderTest() throws InterruptedException, IOException {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
        paymentPage = new PaymentPage(driver);
        confirmationPage = new ConfirmationPage(driver);

        File payload = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/data.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Payment data = objectMapper.readValue(payload,Payment.class);

        loginPage.loginIntoApplication(readProperties.getEmail(),readProperties.getPassword());
        Assert.assertEquals(ReusuableFunctions.getTitle(),"Let's Shop");

        List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='card-body']/h5"));
        for (WebElement productName : productNames) {
            System.out.println(productName.getText());
            if (productName.getText().equals("ADIDAS ORIGINAL")) {
                dashboardPage.clickOnViewProduct();
                break;
            }
        }
        productDetailsPage.clickOnAddToCart();
        dashboardPage.clickOnCart();
        cartPage.clickOnCheckOut();
        paymentPage.enterPaymentDetails(data.getCardNumber(), data.getCardName(), data.getCVV()).clickOnPlaceOrder();
        Assert.assertEquals(confirmationPage.getConfirmationMessage(),"THANKYOU FOR THE ORDER.");
        dashboardPage.clickOnSignOut();
    }
}
