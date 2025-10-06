package com.demo.tests;

import org.testng.annotations.Test;

import com.demo.pages.LoginPage;

import org.testng.Assert;

public class LoginTest extends BaseTest {

    //verify valid username and password
    @Test
    public void validLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("standard_user",  "secret_sauce");
        handleAlert();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login with valid credentials");
    }
   
    //verify inavlid username and password
    @Test
    public void invaldLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("invalid_user", "invlaid_pass");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));

    }
    
}
