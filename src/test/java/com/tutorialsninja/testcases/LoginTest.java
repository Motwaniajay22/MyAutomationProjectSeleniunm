package com.tutorialsninja.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tutorialsninja.base.BaseTest;
import com.tutorialsninja.pageobjects.AccountPage;
import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.LoginPage;



public class LoginTest extends BaseTest {
	HomePage homepage;
	LoginPage loginpage;
	AccountPage account;

	@Test(groups = { "smoke", "regression" })
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
		Assert.assertEquals(accountText, "My Account");
		logger.info("TC001_validLogin()  Passed");
	}

	@Test(priority = 2, groups = { "smoke", "regression" })
	public void TC002_loginWithValidUserAndInvalidPassword() {

		logger.info("TC002_loginWithValidUserAndInvalidPassword() Started");
		homepage = new HomePage(driver);
		logger.info("Navigate to login page");
		homepage.navigateToLoginPage();

		loginpage = new LoginPage(driver);
		logger.info("Entered valid email and in valid password, clicked on login button");
		loginpage.login(prop.getProperty("ValidEmail"), prop.getProperty("InvalidPassword"));

		String actualText = loginpage.getErrorLoginMsg();
		logger.info("comparing result");
		Assert.assertTrue(
				actualText.contains("Warning: No match for E-Mail Address and/or Password.") || actualText.contains(
						"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
		logger.info("TC002_loginWithValidUserAndInvalidPassword() Passed");

	}

	@Test(priority = 3, groups = { "regression" })
	public void TC003_loginWithInvalidUserAndValidPassword() {
		logger.info("TC003_loginWithInvalidUserAndValidPassword() Started");
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();

		loginpage = new LoginPage(driver);
		loginpage.login(prop.getProperty("InvalidEmail"), prop.getProperty("ValidPassword"));

		String actualText = loginpage.getErrorLoginMsg();
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

		String actualText = loginpage.getErrorLoginMsg();

		Assert.assertTrue(
				actualText.contains("Warning: No match for E-Mail Address and/or Password.") || (actualText.contains(
						"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.")));
	}

	@Test(priority = 5)
	public void TC005_verifyLoginPageTitle() throws InterruptedException {
		logger.info("TC005_verifyLoginPageTitle()  Started");
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();

		loginpage = new LoginPage(driver);
		loginpage.login(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		
		String title = driver.getTitle();
		Thread.sleep(3000);
		Assert.assertEquals(loginpage.getLoginPageTitle(), title);
	}

	@Test(priority = 6)
	public void TC006_verifyLoginPageUrl() {
		logger.info("TC006_verifyLoginPageUrl() Started");
		homepage = new HomePage(driver);
		homepage.navigateToLoginPage();

		loginpage = new LoginPage(driver);
		loginpage.login(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));
		String curl = driver.getCurrentUrl();
		
		Assert.assertEquals(loginpage.getLoginPageUrl(),curl);

	}

	
}
