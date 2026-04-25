package com.tutorialsninja.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tutorialsninja.action.Action;

public class HomePage {

    WebDriver driver;
    Action action;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(driver);
    }

    //  LOCATORS (By instead of WebElement)
    private By searchBar = By.xpath("//input[@name='search']");
    private By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
    private By myAccountDropDown = By.xpath("//a[@title='My Account']");
    private By loginOption = By.linkText("Login");
    private By registerOption = By.linkText("Register");

    //  ACTION METHODS

    public void openMyAccountDropdown() {
        action.click(myAccountDropDown);
    }

    public void navigateToLoginPage() {
        openMyAccountDropdown();
        action.click(loginOption);
    }

    public void navigateToRegisterPage() {
        openMyAccountDropdown();
        action.click(registerOption);
    }

    // OPTIONAL: SEARCH FEATURE
    public void searchProduct(String product) {
        action.enterText(searchBar, product);
        action.click(searchButton);
    }
}