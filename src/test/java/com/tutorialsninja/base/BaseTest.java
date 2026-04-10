package com.tutorialsninja.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tutorialsninja.action.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static Properties prop;
	public static WebDriver driver;
	public static Action action;

	public static Logger logger = LogManager.getLogger(BaseTest.class);

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		loadConfig();
		launchBrowser();
	}

	public void loadConfig() {
		try {
			prop = new Properties();
			logger.info("Loading config file");

			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/config.properties");

			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void launchBrowser() {

		String browser = prop.getProperty("browser");
		logger.info("Browser selected: " + browser);

		if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			// 🔥 Jenkins Safe Config
			//options.addArguments("--disable-blink-features=AutomationControlled");
			//options.addArguments("--headless=new");   // 👉 comment this if you want UI
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");

			driver = new ChromeDriver(options);

			logger.info("Chrome Browser Launched");

		} else if (browser.equalsIgnoreCase("FireFox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox Browser Launched");

		} else {
			logger.error("Invalid browser name");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));

		logger.info("Application Launched: " + prop.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			logger.info("Browser Closed");
		}
	}

	public static String captureScreenShot(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // ✅ FIXED

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir")
				+ "/Screenshots/" + tname + "_" + timeStamp + ".png"; // ✅ Jenkins safe

		File targetFile = new File(targetFilePath);
		FileHandler.copy(sourceFile, targetFile);

		return targetFilePath;
	}
} 

/*public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	public static Action action;

	public static Logger logger = LogManager.getLogger(BaseClass.class);

	@BeforeMethod
	public void setUp() {
		loadConfig();
		launchBrowser();
	}

	public void loadConfig() {
		try {
			prop = new Properties();
			logger.info("Launching browser");
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void launchBrowser()
	{
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
	}
	

	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			logger.info("browser Closed");
		}

	}
	
	public static String captureScreenShot(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile= new File(targetFilePath);
		//sourceFile.renameTo(targetFile);
		FileHandler.copy(sourceFile, targetFile);
		return targetFilePath;
	}

}*/
