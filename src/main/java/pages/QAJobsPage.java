package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QAJobsPage {

    private final WebDriver driver;
    private final String URL = "https://useinsider.com/careers/quality-assurance/";

    private final By seeAllQaJobsButton = By.xpath("//a[contains(text(),'See all QA jobs')]");


    public QAJobsPage(WebDriver driver) {
        this.driver = driver; // WebDriver'ı başlatır
    }

    public void open() {
        driver.get(URL); // Belirtilen URL'yi tarayıcıda açar
    }

    public void clickSeeAllQaJobsButton() {
        driver.findElement(seeAllQaJobsButton).click(); // "See all QA jobs" butonuna tıklar
    }

}
