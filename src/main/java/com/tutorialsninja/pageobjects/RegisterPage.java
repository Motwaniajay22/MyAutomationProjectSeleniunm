package com.tutorialsninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.action.Action;

public class RegisterPage {
	WebDriver driver;
	Action action;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		action = new Action(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement fname;
	@FindBy(id = "input-lastname")
	WebElement lname;
	@FindBy(id = "input-email")
	WebElement email;
	@FindBy(id = "input-telephone")
	WebElement tel;
	@FindBy(id = "input-password")
	WebElement pass;
	@FindBy(id = "input-confirm")
	WebElement cpass;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement agreecheckbox;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebutton;
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement accountSuccess;
	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	WebElement emailmandatorymsg;
	@FindBy(xpath = "//div[contains(text(),'Warning: E-Mail Address is already registered!')]")
	WebElement existEmailMsg;

	public void newAccountRegister(String fname, String lname, String email, String tel, String pass, String cpass) {
		action.enterText(this.fname, fname);
		action.enterText(this.lname, lname);
		action.enterText(this.email, email);
		action.enterText(this.tel, tel);
		action.enterText(this.pass, pass);
		action.enterText(this.cpass, cpass);
		action.click(agreecheckbox);
		action.click(continuebutton);

	}

	public void firstName(String fname) {
		action.enterText(this.fname, fname);
	}

	public void lastName(String lname) {
		action.enterText(this.lname, lname);
	}

	public void email(String email) {
		action.enterText(this.email, email);
	}

	public void telephone(String tel) {
		action.enterText(this.tel, tel);
	}

	public void password(String pass) {
		action.enterText(this.pass, pass);
	}

	public void confirmPassword(String cpass) {
		action.enterText(this.cpass, cpass);
	}

	public void agreeCheckbox() {
		action.click(agreecheckbox);
	}

	public void continueButton() {
		action.click(continuebutton);
	}

	public String accountSuccessMsg() {

		return action.getText(accountSuccess);
	}

	public String emailMandatoryMsg() {

		return action.getText(emailmandatorymsg);
	}

	public String existingEmailMsg() {
		return action.getText(existEmailMsg);
	}

}
