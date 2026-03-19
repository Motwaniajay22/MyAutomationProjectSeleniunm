package com.tutorialsninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.action.Action;
import com.tutorialsninja.base.BaseClass;

public class AccountPage extends BaseClass {
	WebDriver driver;
	Action action;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		action = new Action(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='content']//h2[text()='My Account']") WebElement MyAccountText;
	
	public String myAccountGetText()
	{
		return MyAccountText.getText();
	}
	
	



}
