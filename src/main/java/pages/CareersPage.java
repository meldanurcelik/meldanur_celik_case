package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CareersPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Career sayfasındaki blokların locator'ları
    private By locationsBlock = By.id("career-our-location");
    private By teamsBlock = By.id("career-find-our-calling");
    private By lifeAtInsiderBlock = By.xpath("//h2[contains(text(),'Life at Insider')]");

    public CareersPage(WebDriver driver) {
        this.driver = driver; // WebDriver'ı başlatır
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 saniyelik dinamik bekleme süresi
    }

    private boolean isElementDisplayed(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Elementin görünür olmasını bekler
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Locations bloğunun görünürlüğünü kontrol eder
    public boolean isLocationsBlockDisplayed() {
        return isElementDisplayed(locationsBlock);
    }

    // Teams bloğunun görünürlüğünü kontrol eder
    public boolean isTeamsBlockDisplayed() {
        return isElementDisplayed(teamsBlock);
    }

    // "Life at Insider" bloğunun görünürlüğünü kontrol eder
    public boolean isLifeAtInsiderBlockDisplayed() {
        return isElementDisplayed(lifeAtInsiderBlock);
    }
}
