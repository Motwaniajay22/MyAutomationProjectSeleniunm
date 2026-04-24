package com.tutorialsninja.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

	// Use By locator instead of WebElement
	private By myAccountText = By.xpath("//h2[contains(text(),'My Account')]");
	private By search = By.xpath("//input[@name='search']");
	private By searchBtn = By.xpath("//button[@type='button']//i[@class='fa fa-search']");
	private By addtocart = By.xpath("//span[contains(text(), 'Add to Cart')]");
	private By addcart = By.id("button-cart");
	private By itemcart = By.xpath("//span[@id='cart-total']");
	private By checkout = By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[2]");
	private By bilingcontinue = By.id("button-payment-address");
	private By deliverycontinue = By.id("button-shipping-address");
	private By deliverymethodcontinue = By.id("button-shipping-method");
	private By paymentcontinue = By.id("button-payment-method");
	private By agreechkbx = By.xpath("//input[@type='checkbox']");
	private By cnfrmbtn = By.id("button-confirm");
	private By ordercrmmsg = By.xpath("//*[@id='content']/h1");

	public String myAccountGetText() {
		action.waitUntilElementToBeVisible(myAccountText);
		return action.getText(myAccountText);
	}

	public void searchText(String search) {
		action.enterText(this.search, search);
	}

	public void searchButton() {
		 action.click(searchBtn);
	}

	public void addToCartButton() {
		action.click(addtocart);
	}
	
	public void addCartToItem()
	{
		action.click(addcart);
	}
	
	public void itemCartButton()
	{
		action.clickJs(itemcart);
	}

	public void bilingContinuebutton() {
		action.click(bilingcontinue);
	}

	public void checkOut() {
		action.click(checkout);
	}

	public void deliveryContinueButton() {
		action.click(deliverycontinue);
	}

	public void deliveryMethodContinueButton() {
		action.click(deliverymethodcontinue);
	}

	public void paymentContinueButton() {
		action.click(paymentcontinue);
	}

	public void agreeChekbox() {
		action.click(agreechkbx);
	}
	
	public void confirmButton()
	{
		action.click(cnfrmbtn);
	}
	
	public String orderconfirmMsg()
	{
		return action.getText(ordercrmmsg);
	}
}