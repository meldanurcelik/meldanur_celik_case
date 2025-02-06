package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CompanyPage {

    private final WebDriver driver;
    private WebDriverWait wait;

    // Menüler
    private final By companyMenu = By.linkText("Company");
    private final By careersMenu = By.linkText("Careers");

    public CompanyPage(WebDriver driver) {
        this.driver = driver; // WebDriver'ı başlatır
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 saniyelik dinamik bekleme süresi

    }

    private void clickMenu(By menuLocator) {
        try {
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuLocator)); // Wait for the element to be clickable
            menu.click(); // Click the menu
        } catch (TimeoutException e) {
            System.err.println("Menu not clickable: " + menuLocator); // You can log or handle the exception as needed
        }
    }


    public void clickCompanyMenu() {
        clickMenu(companyMenu); // "Company" menüsüne tıklar
    }

    public void clickCareersMenu() {
        clickMenu(careersMenu); // "Careers" menüsüne tıklar
    }

}
