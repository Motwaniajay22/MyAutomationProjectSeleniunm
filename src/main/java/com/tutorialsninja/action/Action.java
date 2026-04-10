package com.tutorialsninja.action;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {

    private WebDriver driver;
    private WebDriverWait wait;

    public Action(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // CLICK
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // ENTER TEXT
    public void enterText(WebElement element, String value) {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
        el.clear();
        el.sendKeys(value);
    }

    // GET TEXT
    public String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    // WAIT CLICKABLE
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // WAIT VISIBLE
    public void waitUntilElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // IS DISPLAYED (SAFE)
    public boolean isDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // TITLE
    public String getTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }

    // URL
    public String getUrl(String url) {
        wait.until(ExpectedConditions.urlContains(url));
        return driver.getCurrentUrl();
    }
}