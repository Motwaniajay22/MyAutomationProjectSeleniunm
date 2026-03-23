package com.tutorialsninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.action.Action;


public class HomePage  {
	
	WebDriver driver;
	Action action;
	
	//constructor
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		action = new Action(driver);
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	@FindBy(xpath = "//input[@name=\"search\"]") 
	WebElement searchBar;
	@FindBy(xpath = "//button[@class=\"btn btn-default btn-lg\"]") 
	WebElement searchButton;
	@FindBy (xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]") 
	WebElement myacountDropDown;
	@FindBy(linkText = "Login") 
	WebElement loginOption;
	@FindBy(linkText = "Register") 
	WebElement registerOption;
	
	//action methods
	
	public void clickMyacountDropDown()
	{
		action.click(myacountDropDown);
	}
	
	public void clickLoginOption()
	{
		action.click(loginOption);
	}
	
	public void navigateToLoginPage()
	{
		action.click(myacountDropDown);
		action.click(loginOption);
	}
	
	public void navigateToRegisterPage()
	{
		action.click(myacountDropDown);
		action.click(registerOption);
	}
	
	
	
	
	

}
