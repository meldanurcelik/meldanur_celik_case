package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        String homePageTitle = driver.getTitle();
        return homePageTitle.contains("Insider");
    }

    private void acceptCookieIfPresent() {
        try {
            WebElement acceptButton = driver.findElement(acceptCookieButton);
            if (acceptButton.isDisplayed()) {
                acceptButton.click();  // Cookie butonuna tıkla
                System.out.println("Cookie accepted.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Cookie accept button not found, no action needed.");
        }
    }

}