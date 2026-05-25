package com.tutorialsninja.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.action.Action;

public class ProductDetailPage {
	WebDriver driver;
	Action action;
	
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		action = new Action(driver);
		PageFactory.initElements(driver,this);
	}
	
	private By productaddtocart = By.xpath("//*[@id='button-cart']");
	private By successmsg = By.xpath("//*[@id='product-product']/div[1]/text()[1]");
	
	public void productDetailAddToCart() {
		action.click(productaddtocart);
	}
	
	public String successProductDetailMsg() {
		return action.getText(successmsg);
	}

}
