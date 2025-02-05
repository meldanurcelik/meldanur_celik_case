package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void clickCompanyMenu() {
        driver.findElement(companyMenu).click(); // "Company" menüsüne tıklar
    }

    public void clickCareersMenu() {
        driver.findElement(careersMenu).click(); // "Careers" menüsüne tıklar
    }

}
