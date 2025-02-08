package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static utils.ScrollUtil.scrollToElement;

public class OpenPositionsPage {
    // The WebDriver and WebDriverWait objects are defined
    private WebDriver driver;
    private WebDriverWait wait;
    // The locators for the Open Positions page elements
    private final By careerPositionList = By.xpath("//section[@id='career-position-list']");
    private final By careerPositionItem = By.xpath("(//section[@id='career-position-list']//p[@class='position-title font-weight-bold'])[1]");
    private final By filterByLocationDropdown = By.xpath("//span[@id='select2-filter-by-location-container']");
    private final By filterByDepartmentDropdown = By.xpath("//span[@id='select2-filter-by-department-container']");
    private final By viewRoleButtonX = By.xpath("(//a[contains(text(),'View Role')])[1]");

    public OpenPositionsPage(WebDriver driver) {
        this.driver = driver; // The constructor takes a WebDriver object
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // The WebDriverWait object is initialized with a 10-second timeout
    }

    public boolean isPositionListItemDisplayed() {
        try {
            scrollToElement(driver, careerPositionList); // Scroll to the position list
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(careerPositionItem)); // Wait for the position list item
            return element.isDisplayed(); // Return true if the element is displayed
        } catch (TimeoutException e) {
            System.out.println("Position list item is NOT displayed: " + e.getMessage());
            return false; // Return false if the element is not displayed
        }
    }

    public void selectLocation(String location) throws InterruptedException {
        WebElement filterDropdown = driver.findElement(filterByLocationDropdown); // Find the location dropdown
        filterDropdown.click(); // Click the location dropdown
        By locationOption = By.xpath("//li[text()='" + location + "']"); // Create a locator for the location option

        int maxRetries = 3; // Maximum number of attempts
        boolean isClicked = false; // Click status

        for (int i = 0; i < maxRetries; i++) {
            try {
                // Wait: Wait for the dropdown content to load
                wait.until(ExpectedConditions.presenceOfElementLocated(locationOption)); // Wait for the location option
                wait.until(ExpectedConditions.elementToBeClickable(locationOption)).click(); // Click the location option
                isClicked = true; // Set the click status to true
                break;
            } catch (Exception e) {
                // Retry: If the dropdown content does not load, try again
                System.out.println("Dropdown did not load, trying again...");
                filterDropdown.click(); // Click the location dropdown
                Thread.sleep(500); // Wait for 500 milliseconds
                filterDropdown.click(); // Click the location dropdown again
            }
        }
        if (!isClicked) {
            // Error: If the dropdown content does not load after the maximum number of attempts, throw an error
            throw new RuntimeException("Dropdown content not loaded, selection not possible!");
        }
    }

    public void validateDepartmentSelection(String department) {
        try {
            WebElement filterDropdown = driver.findElement(filterByDepartmentDropdown); // Find the department dropdown
            String selectedText = filterDropdown.getText(); // Get the selected text
            if (selectedText.equals(department)) { // Check if the selected text is equal to the department
                System.out.println(department + " is selected.");
            } else {
                System.out.println(department + " is not selected.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Dropdown element not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while validating the department selection: " + e.getMessage());
        }
    }

    public void hoverAndClickViewRoleButton() {
        try {
            WebElement viewRoleButton = driver.findElement(viewRoleButtonX); // Find the "View role" button
            Actions actions = new Actions(driver); // Create an Actions object
            actions.moveToElement(viewRoleButton).click().perform(); // Hover over the element and click
        } catch (NoSuchElementException e) {
            System.out.println("View role button not found: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            System.out.println("Unable to interact with the view role button: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while hovering and clicking the view role button: " + e.getMessage());
        }
    }

}