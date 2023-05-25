package com.ecommerce.TestCases;

import com.ecommerce.BaseClass.BaseClass;
import com.ecommerce.Pages.DashboardPage;
import com.ecommerce.Pages.LoginPage;
import com.ecommerce.Utilities.ReusuableFunctions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void login(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        loginPage.loginIntoApplication(readProperties.getEmail(), readProperties.getPassword());
        Assert.assertEquals(ReusuableFunctions.getTitle(),"Let's Shop");

        dashboardPage.clickOnSignOut();
    }
}
