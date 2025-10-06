package com.demo.tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
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

               // After clicking add to cart or checkout button:
try {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.alertIsPresent());

    Alert alert = driver.switchTo().alert();
    System.out.println("Alert says: " + alert.getText());
    alert.accept();  // or alert.dismiss();

} catch (TimeoutException e) {
    // No alert appeared, continue test
    System.out.println("No alert appeared");
}

        ProductPage productPage=new ProductPage(driver);
        productPage.addFirstItemToCart();
        productPage.goToCart();

       Assert.assertTrue(driver.getCurrentUrl().contains("cart"),"User should be on cart page");
        

    }
    
}
