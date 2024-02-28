package com.saucedemo.uitests.pages.homepage;

import com.saucedemo.uitests.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id='inventory_filter_container']/div")
    WebElement homePageHeaderText;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Get the header's text from Home Page
    public String getHomePageHeaderText() {
        return homePageHeaderText.getText();
    }
}
