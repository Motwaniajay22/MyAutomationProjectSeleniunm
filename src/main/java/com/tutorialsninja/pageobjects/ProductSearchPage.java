package com.tutorialsninja.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.action.Action;

public class ProductSearchPage {
	WebDriver driver;
	Action action;
	
	public ProductSearchPage(WebDriver driver) {
		this.driver = driver;
		action = new Action(driver);
		PageFactory.initElements(driver, this);
	}
	
	private By addtocartproduct = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/span");

	
	
	
	public void addToCartProductClick() {
		action.click(addtocartproduct);
	}
}
