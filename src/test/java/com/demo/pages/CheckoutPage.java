package com.demo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private WebDriver driver;

    //private By checkOutButton =By.id("checkout");
    private By firstName= By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton =By.id("continue");
    private By finishButton =By.id("finish");
    private By confirmationMessage= By.className("complete-header");
   
   
    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    public void checkOut(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement checkoutButton = wait.until(
    ExpectedConditions.elementToBeClickable(By.id("checkout"))
);
checkoutButton.click();

        
    }
    public void fillDetails(String fname,String lname,String zip){
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueButton).click();
    }

    public void finishCheckOut(){
        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage(){
        return driver.findElement(confirmationMessage).getText();
    }
    
}
