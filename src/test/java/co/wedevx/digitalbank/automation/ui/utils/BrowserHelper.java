package co.wedevx.digitalbank.automation.ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
WebDriver Helper Extensions is designed to simplify Java based Selenium/WebDriver tests.
It is built on top of Selenium/WebDriver to make your test more readable, reusable and maintainable
by providing easy handling browsers and advance identifiers.
 */
public class BrowserHelper {

    //Use the BrowserHelper methods to handle waits when interacting with elements in your test cases.

    //wait until the element is visible
    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
        //If we have 10 elements for explicit wait, it means we will have 20 lines
        //by doing this wea re reducing our code by half and write 10 times
    }

    //wait until the element is clickable and click on it
    public static WebElement waitUntilElementClickableAndClick(WebDriver driver, WebElement element,
                                                               int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
        return clickableElement;
    }


}
