package com.tutorialsninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.action.Action;

public class HomePage {

    WebDriver driver;
    Action action;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='search']")
    WebElement searchBar;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id='top-links']/ul/li[2]/a/span[1]")
    WebElement myAccountDropDown;

    @FindBy(linkText = "Login")
    WebElement loginOption;

    @FindBy(linkText = "Register")
    WebElement registerOption;

    // safer navigation methods

    public void openMyAccountDropdown() {
        action.waitForElementToBeClickable(myAccountDropDown);
        action.click(myAccountDropDown);
    }

    public void navigateToLoginPage() {
        openMyAccountDropdown();
        action.waitForElementToBeClickable(loginOption);
        action.click(loginOption);
    }

    public void navigateToRegisterPage() {
        openMyAccountDropdown();
        action.waitForElementToBeClickable(registerOption);
        action.click(registerOption);
    }
}