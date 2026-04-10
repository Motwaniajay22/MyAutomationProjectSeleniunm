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
		System.getProperty("user.dir") + "/src/test/resources/config.properties");
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
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        options.addArguments("--disable-notifications");
	        options.addArguments("--remote-allow-origins=*");

	        driver = new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
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

}
