package com.tutorialsninja.testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorialsninja.base.BaseTest;
import com.tutorialsninja.pageobjects.AccountPage;
import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.LoginPage;

public class AccountPageTest extends BaseTest {

	HomePage homepage;
	LoginPage loginpage;
	AccountPage account;

	@Test
	public void TC001_searchProduct(){
		homepage = new HomePage(driver);
		logger.info("Navigating to login page");
		homepage.navigateToLoginPage();
		loginpage = new LoginPage(driver);
		logger.info("Entered valid username and password");
		loginpage.login(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		account = new AccountPage(driver);
		
		logger.info("Product searched");
		account.searchText("Hp");
		logger.info("Clicked on search button");
		account.searchButton();
		logger.info("Clicked on addtocart button");
		account.addToCartButton();
		logger.info("Clicked on addCartToItem button");
		account.addCartToItem();
		logger.info("Clicked on itemCartButton button");
		account.itemCartButton();
		logger.info("Clicked on checkOut button");
		account.checkOut();
		logger.info("Selecting details");
		account.bilingContinuebutton();
		account.deliveryContinueButton();
		account.deliveryMethodContinueButton();
		account.agreeChekbox();
		account.paymentContinueButton();
		
		logger.info("Clicked on confirm button");
		account.confirmButton();
	
		
		
		logger.info("Validation actual and expected result");
		String text = account.orderconfirmMsg();
		System.out.println(text);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Assert.assertEquals(text, "Your order has been placed!");
		

	}
}
