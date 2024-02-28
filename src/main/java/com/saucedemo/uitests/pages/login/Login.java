package com.saucedemo.uitests.pages.login;

import com.saucedemo.uitests.pages.BasePage;
import com.saucedemo.uitests.pages.homepage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login extends BasePage {
    private final static Logger LOGGER = LoggerFactory.getLogger(Login.class);
    @FindBy(name = "user-name")
    WebElement inputUserName;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id='login_button_container']/div/form/h3")
    WebElement unsuccessLoginText;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void setUserName(String strUserName) {
        inputUserName.sendKeys(strUserName);
    }

    //Set password
    public void setPassword(String strPassword) {
        inputPassword.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin() {
        loginButton.click();
    }

    public HomePage login(String strUserName, String strPasword) {
        LOGGER.info("Start check successful login.");
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();
        LOGGER.info("Click login button");
        LOGGER.debug("Debug check successful login.");
        LOGGER.info("Finish check successful login.");

        return new HomePage(driver);
    }

    public String getUnsuccessLoginText() {
        return unsuccessLoginText.getText();
    }

    public Login loginUnsuccess(String strUserName, String strPasword) {
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();
        return this;
    }
}
