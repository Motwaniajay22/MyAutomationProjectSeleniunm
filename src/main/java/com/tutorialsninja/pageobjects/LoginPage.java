package com.tutorialsninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.action.Action;

public class LoginPage {

    WebDriver driver;
    Action action;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;

    @FindBy(css = "div.alert.alert-danger")
    WebElement errorMsg;

    // Actions

    public void login(String uemail, String upassword) {
        action.waitUntilElementToBeVisible(email);
        action.enterText(email, uemail);
        action.enterText(password, upassword);
        action.click(loginBtn);
    }

    public void enterEmail(String emailValue) {
        action.waitUntilElementToBeVisible(email);
        action.enterText(this.email, emailValue);
    }

    public void enterPassword(String passwordValue) {
        action.waitUntilElementToBeVisible(password);
        action.enterText(this.password, passwordValue);
    }

    public void clickLoginButton() {
        action.waitForElementToBeClickable(loginBtn);
        action.click(loginBtn);
    }

    public String getErrorLoginMsg() {
        action.waitUntilElementToBeVisible(errorMsg);
        return action.getText(errorMsg);
    }

    public String getLoginPageTitle() {
        return action.getTitle(driver.getTitle());
        
    }

    public String getLoginPageUrl() {
        return action.getUrl(driver.getCurrentUrl());
    	
    }
}