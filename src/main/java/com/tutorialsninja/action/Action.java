package com.tutorialsninja.action;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {
	private WebDriver driver;
	private WebDriverWait wait;

	public Action(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Click WebElement
	public void click(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			System.out.println("Unable to click element: " + e.getMessage());
		}
	}

	// Enter text
	public void enterText(WebElement element, String value) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Unable to enter text: " + e.getMessage());
		}
	}

	// To get text
	public String getText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}

	// Wait until element clickable
	public void waitForElementToBeClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println("Element is not clickable: " + e.getMessage());
		}
	}

	// Wait until element visible
	public void waitUntilElementToBeVisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Element is not visile: " + e.getMessage());
		}
	}

	public boolean isDisplayed(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}

	public String getTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public String getUrl(String url) {
		wait.until(ExpectedConditions.urlContains(url));
		return driver.getCurrentUrl();

	}

}
