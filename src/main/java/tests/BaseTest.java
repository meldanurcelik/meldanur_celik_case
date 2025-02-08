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

    protected static WebDriver driver; // WebDriver is protected so that it can be accessed by subclasses

    @BeforeAll
    public static void setup() {
        String browser = System.getProperty("browser", "chrome"); // Select the browser from system properties, otherwise use Chrome as default

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize(); // Make the window full screen
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set the implicit wait time to 10 seconds
    }

    @AfterEach
    public void takeScreenshotOnFailure(TestInfo testInfo) {
        if (driver != null) {
            // @AfterEach runs after each test and screenshots are taken after each test
            // The TestInfo object provides information about the test
            // If the test fails, a screenshot is taken
            TakesScreenshot ts = (TakesScreenshot) driver; // Ekran görüntüsü almak için WebDriver'ı dönüştür
            File srcFile = ts.getScreenshotAs(OutputType.FILE); // Take a screenshot
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")); // Get the current time as a timestamp
            String testName = testInfo.getDisplayName().replace(" ", "_"); // Get the test name and replace spaces with underscores
            File destFile = new File("Screenshots/" + testName + "_" + timestamp + ".png"); // Create a file path for the screenshot

            try {
                FileUtils.copyFile(srcFile, destFile); // Save the screenshot to the file path
                System.out.println("Screenshot saved: " + destFile.getAbsolutePath()); // Print the file path
            } catch (IOException e) {
                System.err.println("An error occurred while saving the screenshot: " + e.getMessage()); // Print an error message if the screenshot fails
            }
        }
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit(); // Close the browser
        }
    }

}
