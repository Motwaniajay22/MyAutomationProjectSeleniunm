package com.tutorialsninja.testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.tutorialsninja.base.BaseTest;
import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.RegisterPage;


public class RegisterTest extends BaseTest {
	HomePage homepage;
	RegisterPage register;

	

	@Test(priority = 2)
	public void TC002_registerWithoutEmail() throws InterruptedException {
		logger.info("TC002_registerWithoutEmail() Started");
		homepage = new HomePage(driver);
		homepage.navigateToRegisterPage();

		register = new RegisterPage(driver);
		register.firstName("akak");
		register.lastName("vk");
		register.telephone("1234567890");
		register.confirmPassword("1234");
		register.confirmPassword("1234");
		register.agreeCheckbox();
		register.continueButton();

		Assert.assertEquals(register.emailMandatoryMsg(), "E-Mail Address does not appear to be valid!");
	}

	@Test(priority = 3)
	public void TC003_registerWithExistingEmail() {
		logger.info("TC003_registerWithExistingEmail() Started");
		homepage = new HomePage(driver);
		homepage.navigateToRegisterPage();

		register = new RegisterPage(driver);
		register.firstName("ajay");
		register.lastName("vk");
		register.email("ajm@gmail.com");
		register.telephone("1234567890");
		register.password("1111");
		register.confirmPassword("1111");
		register.agreeCheckbox();
		register.continueButton();

		Assert.assertEquals(register.existingEmailMsg(), "Warning: E-Mail Address is already registered!");
	}

}
