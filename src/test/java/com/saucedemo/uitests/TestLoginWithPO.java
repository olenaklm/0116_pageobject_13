package com.saucedemo.uitests;

import com.saucedemo.uitests.pages.homepage.HomePage;
import com.saucedemo.uitests.pages.login.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLoginWithPO {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    /**
     * This test go to https://www.saucedemo.com/v1/index.html
     * Login to application
     * Verify the home page has text Products
     */

    //@Test(priority=0)
    //@Test
    @Test(groups =  {"smoke", "regression"})
    public void testSuccessLogin() {
        //Create Login Page object
        Login objLogin = new Login(driver);
        //login to application
        HomePage objHomePage = objLogin.login("standard_user", "secret_sauce");

        //Verify home page
        Assert.assertTrue(objHomePage.getHomePageHeaderText().toLowerCase().contains("products"));
    }


    @Test(groups = {"smoke"})
    public void testUnsuccessLogin() {
        Login objLogin = new Login(driver)
                .loginUnsuccess("standard_user", "");
 //       Assert.assertTrue(objLogin.getUnsuccessLoginText().contains("Password is required"));
        Assert.assertFalse(objLogin.getUnsuccessLoginText().contains("Password is required"));
    }
}
