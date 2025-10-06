package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.pages.CheckoutPage;
import com.demo.pages.LoginPage;
import com.demo.pages.ProductPage;

public class CheckoutTest extends BaseTest {
    
    @Test
    public void completeCheckOut(){
        // Login
       LoginPage loginPage=new LoginPage(driver);
       loginPage.login("standard_user", "secret_sauce");   
       // Add to cart
       
       ProductPage productPage=new ProductPage(driver);
       productPage.addFirstItemToCart();
       productPage.goToCart();

        // Checkout
       CheckoutPage checkoutPage=new CheckoutPage(driver);
       checkoutPage.checkOut();
       checkoutPage.fillDetails("John", "Doe", "12345");
       checkoutPage.finishCheckOut();

       Assert.assertEquals(checkoutPage.getConfirmationMessage(), "Thank you for your order!");
    }
}
