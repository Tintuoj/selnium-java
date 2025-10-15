package com.demo.tests;


import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.pages.LoginPage;
import com.demo.pages.ProductPage;

public class CartTest extends BaseTest{
    
    @Test
    public void addToCart(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        handleAlert();
        ProductPage productPage=new ProductPage(driver);
        productPage.addFirstItemToCart();
        productPage.goToCart();
        
    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("cart"));

       Assert.assertTrue(driver.getCurrentUrl().contains("cart"),"User should be on cart page");
        

    }
    
}
