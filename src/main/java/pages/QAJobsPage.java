package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void clickSeeAllQaJobsButton() {
        driver.findElement(seeAllQaJobsButton).click(); // "See all QA jobs" butonuna tıklar
    }

}