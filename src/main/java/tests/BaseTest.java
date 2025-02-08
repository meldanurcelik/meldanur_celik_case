package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void setup() {
        String browser = System.getProperty("browser", "chrome");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Geçersiz tarayıcı: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void takeScreenshotOnFailure(TestInfo testInfo) {
        if (driver != null) {
            // @AfterEach her testten sonra çalışır ve her testten sonra ekran görüntüsü alınır
            // TestInfo nesnesi, test hakkında bilgi sağlar
            // Test başarısız olursa ekran görüntüsü alınır
            TakesScreenshot ts = (TakesScreenshot) driver; // Ekran görüntüsü almak için WebDriver'ı dönüştür
            File srcFile = ts.getScreenshotAs(OutputType.FILE); // Ekran görüntüsünü al
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")); // Zaman damgası oluştur
            String testName = testInfo.getDisplayName().replace(" ", "_"); // Test adını al ve boşlukları alt çizgi ile değiştir
            File destFile = new File("Screenshots/" + testName + "_" + timestamp + ".png"); // Ekran görüntüsünü kaydetmek için dosya adı oluştur

            try {
                FileUtils.copyFile(srcFile, destFile); // Ekran görüntüsünü kaydet
                System.out.println("Ekran görüntüsü kaydedildi: " + destFile.getAbsolutePath()); // Ekran görüntüsünün kaydedildiği yolu yazdır
            } catch (IOException e) {
                System.err.println("Ekran görüntüsü kaydedilirken hata oluştu: " + e.getMessage()); // Hata durumunda hata mesajı yazdır
            }
        }
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
