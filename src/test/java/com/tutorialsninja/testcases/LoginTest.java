package com.tutorialsninja.testcases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.tutorialsninja.base.BaseClass;
import com.tutorialsninja.pageobjects.AccountPage;
import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.LoginPage;
import com.tutorialsninja.utility.ExcelUtil;

public class LoginTest extends BaseClass {
	HomePage homepage;
	LoginPage loginpage;
	AccountPage account;

	@Test(priority = 1)
	public void TC001_validLogin() {

		logger.info("TC001_validLogin()  started");

		homepage = new HomePage(driver);

		logger.info("Clicked on My Account drop-down and clicked on login option");
		homepage.navigateToLoginPage();

		loginpage = new LoginPage(driver);

		logger.info("User name and Password entered and clicked on login button");
		loginpage.login(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));

		account = new AccountPage(driver);
		String accountText = account.myAccountGetText();

		logger.info("Validation actual and expected result");
		Assert.assertEquals(accountText, "y Account");
		logger.info("TC001_validLogin()  Passed");
	}

	@Test(priority = 2)
	public void TC002_loginWithValidUserAndInvalidPassword() {

		logger.info("TC002_loginWithValidUserAndInvalidPassword() Started");
		homepage = new HomePage(driver);
		logger.info("Navigate to login page");
		homepage.navigateToLoginPage();

		loginpage = new LoginPage(driver);
		logger.info("Entered valid email and in valid password, clicked on login button");
		loginpage.login(prop.getProperty("ValidEmail"), prop.getProperty("InvalidPassword"));

		String actualText = loginpage.getErroLoginMsg();
		logger.info("comparing result");
		Assert.assertTrue(
				actualText.contains("Warning: No match for E-Mail Address and/or Password.") || actualText.contains(
						"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
		logger.info("TC002_loginWithValidUserAndInvalidPassword() Passed");

	}

	@Test(priority = 3)
	public void TC003_loginWithInvalidUserAndValidPassword() {
		logger.info("TC003_loginWithInvalidUserAndValidPassword() Started");
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();

		loginpage = new LoginPage(driver);
		loginpage.login(prop.getProperty("InvalidEmail"), prop.getProperty("ValidPassword"));

		String actualText = loginpage.getErroLoginMsg();
		Assert.assertTrue(
				actualText.contains("Warning: No match for E-Mail Address and/or Password.") || (actualText.contains(
						"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.")));
	}

	@Test(priority = 4)
	public void TC004_loginWithInvalidUserAndPassword() {
		logger.info("TC004_loginWithInvalidUserAndPassword()  Started");
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();

		loginpage = new LoginPage(driver);
		loginpage.login(prop.getProperty("InvalidEmail"), prop.getProperty("InvalidPassword"));

		String actualText = loginpage.getErroLoginMsg();

		Assert.assertTrue(
				actualText.contains("Warning: No match for E-Mail Address and/or Password.") || (actualText.contains(
						"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.")));
	}

	@Test(priority = 5)
	public void TC005_verifyLoginPageTitle() {
		logger.info("TC005_verifyLoginPageTitle()  Started");
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();

		loginpage = new LoginPage(driver);
		loginpage.login(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));

		Assert.assertEquals(loginpage.loginPageTitle(), "My Account");
	}

	@Test(priority = 6)
	public void TC006_verifyLoginPageUrl() {
		logger.info("TC006_verifyLoginPageUrl() Started");
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();

		loginpage = new LoginPage(driver);
		loginpage.login(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));

		Assert.assertEquals(loginpage.loginPageUrl(),
				"https://tutorialsninja.com/demo/index.php?route=account/account");

	}

	@Test
	public void excelDataLogin() throws IOException {
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();
		String filePath = System.getProperty("user.dir") + "\\Testdata\\testdata.xlsx";
		String email = ExcelUtil.getCellData(filePath, "Sheet1", 1, 0);
		String pass = ExcelUtil.getCellData(filePath, "Sheet1", 1, 1);
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterEmail(email);
		loginpage.enterPassword(pass);
		loginpage.clickLoginbtn();
		Assert.assertEquals(loginpage.loginPageUrl(),
				"https://tutorialsninja.com/demo/index.php?route=account/account");
	}

	@Test
	public void excelDataLoginMultiple() throws IOException {
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();
		String filePath = System.getProperty("user.dir") + "\\Testdata\\testdata.xlsx";
		int rows = ExcelUtil.getRowCount(filePath, "Sheet1");
		for (int i = 1; i <= rows; i++) {
			String email = ExcelUtil.getCellData(filePath, "Sheet1", i, 0);
			String pass = ExcelUtil.getCellData(filePath, "Sheet1", i, 1);
			
			LoginPage loginpage = new LoginPage(driver);

			loginpage.enterEmail(email);
			loginpage.enterPassword(pass);
			loginpage.clickLoginbtn();
			System.out.println("login with " + email + pass);
			Assert.assertEquals(loginpage.loginPageUrl(),
					"https://tutorialsninja.com/demo/index.php?route=account/account");
			driver.navigate().back();
		}
	}
}
