package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CompanyPage {
    // The WebDriver and WebDriverWait objects are defined
    private WebDriver driver;
    private WebDriverWait wait;
    // The locators for the Company page elements
    private final By companyMenu = By.linkText("Company");
    private final By careersMenu = By.linkText("Careers");

    public CompanyPage(WebDriver driver) {
        this.driver = driver; // The constructor takes a WebDriver object
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // The WebDriverWait object is initialized with a 10-second timeout
    }

    private void clickMenu(By menuLocator) {
        try {
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuLocator)); // Wait for the element to be clickable
            menu.click(); // Click the element
        } catch (Exception e) {
            System.err.println("Error clicking Company Menu: " + e.getMessage()); // Log error
        }
    }

    // The methods click the Company and Careers menus
    public void clickCompanyMenu() {
        try {
            clickMenu(companyMenu);  // Try to click the Company menu
        } catch (Exception e) {
            System.err.println("Error clicking Company Menu: " + e.getMessage());  // Log error
        }
    }

    // The methods click the Company and Careers menus
    public void clickCareersMenu() {
        try {
            clickMenu(careersMenu);  // Try to click the Careers menu
        } catch (Exception e) {
            System.err.println("Error clicking Careers Menu: " + e.getMessage());  // Log error
        }
    }

}