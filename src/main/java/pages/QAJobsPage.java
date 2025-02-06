package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class QAJobsPage {

    private final WebDriver driver;
    private final String URL = "https://useinsider.com/careers/quality-assurance/";
    private WebDriverWait wait; // Belirli elementleri beklemek için WebDriverWait

    private final By seeAllQaJobsButton = By.xpath("//a[contains(text(),'See all QA jobs')]");

    public QAJobsPage(WebDriver driver) {
        this.driver = driver; // WebDriver'ı başlatır
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 saniyelik dinamik bekleme süresi
    }

    public void open() {
        driver.get(URL); // Belirtilen URL'yi tarayıcıda açar
    }

    private void clickIfClickable(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator)); // Elementin tıklanabilir olmasını bekler
            element.click(); // Butona tıklar
        } catch (TimeoutException e) {
            System.out.println("Element not clickable: " + locator); // Eğer element tıklanabilir değilse hata mesajı
        }
    }

    public void clickSeeAllQaJobsButton() {
        clickIfClickable(seeAllQaJobsButton); // "See all QA jobs" butonuna tıklar
    }

}