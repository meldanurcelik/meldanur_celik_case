package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {
    // The WebDriver and WebDriverWait objects are defined
    private WebDriver driver;
    private WebDriverWait wait;
    // The URL of the home page
    private final String URL = "https://useinsider.com/";
    // The locator for the cookie accept button
    private final By acceptCookieButton = By.id("wt-cli-accept-all-btn");

    public HomePage(WebDriver driver) {
        this.driver = driver; // The constructor takes a WebDriver object
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));  // The WebDriverWait object is initialized with a 10-second timeout
    }

    public void open() {
        try {
            driver.get(URL);  // Open the home page
        } catch (Exception e) {
            System.out.println("Error opening the home page: " + e.getMessage());  // Log the error if URL cannot be opened
        }
        acceptCookieIfPresent();  // Accept the cookie if it is present
    }

    // The method checks if the home page title is displayed
    public boolean isHomePageTitleDisplayed() {
        return driver.getTitle().contains("Insider");
    }

    private void clickIfVisible(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));  // Wait for the element to be clickable
            element.click();  // Click the element
        } catch (Exception e) {
            System.out.println("Error clicking element: " + e.getMessage());  // Catch any other exceptions and log them
        }
    }

    // The method accepts the cookie if it is present
    private void acceptCookieIfPresent() {
        clickIfVisible(acceptCookieButton);
    }

}