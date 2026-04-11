package com.tutorialsninja.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.action.Action;

public class LoginPage {

    WebDriver driver;
    Action action;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Action(driver);
        PageFactory.initElements(driver, this); // not needed but can keep
    }

    // Locators using By
    By email = By.id("input-email");
    By password = By.id("input-password");
    By loginBtn = By.xpath("//input[@value='Login']");
    By errorMsg = By.cssSelector("div.alert.alert-danger");

    // Actions

    public void login(String uemail, String upassword) {
        action.enterText(email, uemail);
        action.enterText(password, upassword);
        action.click(loginBtn);
    }

    public void enterEmail(String uemail) {
        action.enterText(email, uemail);
    }

    public void enterPassword(String upassword) {
        action.enterText(password, upassword);
    }

    public void clickLoginButton() {
        action.click(loginBtn);
    }

    // Validations

    public String getErrorLoginMsg() {
        return action.getText(errorMsg);
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public String getLoginPageUrl() {
        return driver.getCurrentUrl();
    }
}