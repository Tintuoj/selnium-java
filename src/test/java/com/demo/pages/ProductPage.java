package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    private By firstItemAddtoCart=By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon=By.className("shopping_cart_link");

    public ProductPage(WebDriver driver){
        this.driver=driver;
    }
    
    public void addFirstItemToCart(){
        driver.findElement(firstItemAddtoCart).click();
        
    }

    public void goToCart(){
        driver.findElement(cartIcon).click();
    }
        
}
