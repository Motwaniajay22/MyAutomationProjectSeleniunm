package com.tutorialsninja.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.action.Action;

public class AccountPage {

    WebDriver driver;
    Action action;

    public AccountPage(WebDriver driver) {
		this.driver = driver;
		action = new Action(driver);
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement myAccountText;

    public String myAccountGetText() {
        action.waitUntilElementToBeVisible(myAccountText);
        return action.getText(myAccountText);
    }
}