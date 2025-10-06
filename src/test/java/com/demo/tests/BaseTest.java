package com.demo.tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        // Initialize the WebDriver instance (e.g., ChromeDriver)
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }

    //Handle Alerts
    public void handleAlert() {
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
    }

    // Add teardown method to close the browser after each test
    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }
    
}
