package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class QAJobsPage {
    // The WebDriver and WebDriverWait objects are defined
    private final WebDriver driver;
    private WebDriverWait wait;
    // The URL of the QA Jobs page
    private final String URL = "https://useinsider.com/careers/quality-assurance/";
    // The locator for the "See all QA jobs" button
    private final By seeAllQaJobsButton = By.xpath("//a[contains(text(),'See all QA jobs')]");

    public QAJobsPage(WebDriver driver) {
        this.driver = driver; // The constructor takes a WebDriver object
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // The WebDriverWait object is initialized with a 10-second timeout
    }

    public void open() {
        driver.get(URL); // Open the QA Jobs page
    }

    private void clickIfClickable(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator)); // Wait for the element to be clickable
            element.click(); // Click the element
        } catch (Exception e) {
            System.err.println("Element not clickable: " + locator);
        }
    }

    // The method clicks the "See all QA jobs" button
    public void clickSeeAllQaJobsButton() {
        clickIfClickable(seeAllQaJobsButton);
    }

}