package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollUtil {

    public static void scrollToElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // The WebDriverWait object is initialized with a 5-second timeout

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Wait for the element to be visible
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // Scroll to the element
        } catch (TimeoutException e) {
            System.out.println("Element not found or not visible: " + locator); // Print an error message if the element is not found or not visible
        }
    }

}