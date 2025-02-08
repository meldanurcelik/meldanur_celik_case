package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CareersPage {
    // The WebDriver and WebDriverWait objects are defined
    private WebDriver driver;
    private WebDriverWait wait;
    // The locators for the Careers page elements
    private By locationsBlock = By.id("career-our-location"); // The locator for the locations block
    private By teamsBlock = By.id("career-find-our-calling"); // The locator for the teams block
    private By lifeAtInsiderBlock = By.xpath("//h2[contains(text(),'Life at Insider')]"); // The locator for the Life at Insider block

    public CareersPage(WebDriver driver) {
        this.driver = driver; // The constructor takes a WebDriver object
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // The WebDriverWait object is initialized with a 10-second timeout
    }

    private boolean isElementDisplayed(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Wait for the element to be visible
            return element != null && element.isDisplayed(); // Return true if the element is displayed
        } catch (Exception e) {
            return false;
        }
    }

    // The methods check if the Careers page elements are displayed
    public boolean isLocationsBlockDisplayed() {
        try {
            return isElementDisplayed(locationsBlock);  // Try to check if the element is displayed
        } catch (Exception e) {
            System.out.println("Error in checking Locations Block visibility: " + e.getMessage());  // Log error
            return false;  // Return false in case of error
        }
    }

    // The methods check if the Careers page elements are displayed
    public boolean isTeamsBlockDisplayed() {
        try {
            return isElementDisplayed(teamsBlock);  // Try to check if the element is displayed
        } catch (Exception e) {
            System.out.println("Error in checking Teams Block visibility: " + e.getMessage());  // Log error
            return false;  // Return false in case of error
        }
    }

    // The methods check if the Careers page elements are displayed
    public boolean isLifeAtInsiderBlockDisplayed() {
        try {
            return isElementDisplayed(lifeAtInsiderBlock);  // Try to check if the element is displayed
        } catch (Exception e) {
            System.out.println("Error in checking Life at Insider Block visibility: " + e.getMessage());  // Log error
            return false;  // Return false in case of error
        }
    }

}