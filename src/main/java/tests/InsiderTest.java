package tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsiderTest {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {
        driver.get("https://useinsider.com/");
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("#1 Leader in Individualized, Cross-Channel CX — Insider");
    }

}