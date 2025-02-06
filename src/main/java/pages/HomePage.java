package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final String URL = "https://useinsider.com/";
    private WebDriverWait wait; // Belirli elementleri beklemek için WebDriverWait

    private final By acceptCookieButton = By.id("wt-cli-accept-all-btn");

    public HomePage(WebDriver driver) {
        this.driver = driver; // WebDriver'ı başlatır
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 saniyelik dinamik bekleme süresi
    }

    public void open() {
        driver.get(URL); // Belirtilen URL'yi tarayıcıda açar
        acceptCookieIfPresent(); // Cookie onayını kontrol eder ve kabul eder
    }

    // Sayfa başlığında "Insider" kelimesinin olup olmadığını kontrol eder
    public boolean isHomePageTitleDisplayed() {
        return driver.getTitle().contains("Insider");
    }

    private void clickIfVisible(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator)); // Elementi tıklanabilir olana kadar bekle
            element.click();
        } catch (TimeoutException e) {
            System.out.println("Element not clickable: " + locator); // Eğer element tıklanabilir değilse hata mesajı
        }
    }

    private void acceptCookieIfPresent() {
        clickIfVisible(acceptCookieButton); // Cookie butonunu kabul et
    }

}