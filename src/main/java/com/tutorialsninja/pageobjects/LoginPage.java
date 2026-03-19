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
		action = new Action(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement email;
	@FindBy(id = "input-password")
	WebElement password;
	@FindBy(xpath = "//input[@value=\"Login\"]")
	WebElement loginbtn;
	@FindBy(css = "div.alert.alert-danger")
	WebElement errorMsg;

	public void login(String uemail, String upassword) {

		action.enterText(email, uemail);
		action.enterText(password, upassword);
		action.click(loginbtn);
	}

	public void enterEmail(String email) {
		action.enterText(this.email, email);
	}

	public void clickLoginbtn() {
		action.click(loginbtn);
	}

	public void enterPassword(String password) {
		action.enterText(this.password, password);
	}

	public String getErroLoginMsg() {

		return action.getText(errorMsg);
	}

	public String loginPageTitle() {

		return action.getTitle("My Account");
	}

	public String loginPageUrl() {
		return action.getUrl("account/account");
	}

}
