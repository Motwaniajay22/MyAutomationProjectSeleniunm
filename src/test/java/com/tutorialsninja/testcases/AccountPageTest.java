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
	public void searchProduct() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();
		loginpage = new LoginPage(driver);
		loginpage.login(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		account = new AccountPage(driver);
		
		account.searchText("Hp");
		account.searchButton();
		account.addToCartButton();
		account.addCartToItem();
		Thread.sleep(3000);
		account.itemCartButton();
		account.checkOut();
		account.bilingContinuebutton();
		account.deliveryContinueButton();
		account.deliveryMethodContinueButton();
		account.agreeChekbox();
		account.paymentContinueButton();
		account.confirmButton();
		
		Assert.assertEquals("Your order has been placed!", "Your order has been placed!");

	}
}
