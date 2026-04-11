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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased for Jenkins
    }

    //click
    public void click(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        scrollToElement(element);

        wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            element.click();
        } catch (Exception e) {
            // Fallback for Jenkins/headless issues
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    // ✅ ENTER TEXT
    public void enterText(By locator, String value) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        element.clear();
        element.sendKeys(value);
    }

    // ✅ GET TEXT
    public String getText(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText();
    }

    // ✅ WAIT FOR CLICKABLE
    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ✅ WAIT FOR VISIBILITY
    public WebElement waitUntilElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ✅ IS DISPLAYED (SAFE)
    public boolean isDisplayed(By locator) {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            ).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // ✅ GET TITLE
    public String getTitle(String title) {
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }

    // ✅ GET URL
    public String getUrl(String url) {
        wait.until(ExpectedConditions.urlContains(url));
        return driver.getCurrentUrl();
    }

    // ✅ SCROLL TO ELEMENT
    public void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", element
            );
        } catch (Exception e) {
            // Ignore if scroll fails
        }
    }
}