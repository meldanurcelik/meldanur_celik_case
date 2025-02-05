package pages;

import org.openqa.selenium.*;

public class CompanyPage {

    private final WebDriver driver;

    // Menüler
    private final By companyMenu = By.linkText("Company");
    private final By careersMenu = By.linkText("Careers");

    public CompanyPage(WebDriver driver) {
        this.driver = driver; // WebDriver'ı başlatır
    }

    public void clickCompanyMenu() {
        driver.findElement(companyMenu).click(); // "Company" menüsüne tıklar
    }

    public void clickCareersMenu() {
        driver.findElement(careersMenu).click(); // "Careers" menüsüne tıklar
    }

}
