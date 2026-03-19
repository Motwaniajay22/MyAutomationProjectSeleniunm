package com.tutorialsninja.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.BaseClass;
import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.RegisterPage;
import com.tutorialsninja.utility.RandomDataGenerator;

public class RegisterTest extends BaseClass {
	HomePage homepage;
	RegisterPage register;

	@Test(priority = 1)
	public void TC001_registerNewAccount() {
		logger.info("TC001_registerNewAccount() Started");
		homepage = new HomePage(driver);
		homepage.navigateToRegisterPage();

		register = new RegisterPage(driver);
		register.newAccountRegister("ajay", "mot", RandomDataGenerator.generatEmail(), "1111122222", "1234", "1234");

		Assert.assertEquals(register.accountSuccessMsg(), "Your Account Has Been Created!");
	}

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

		Assert.assertEquals(register.emailMandatoryMsg(), "-Mail Address does not appear to be valid!");
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
