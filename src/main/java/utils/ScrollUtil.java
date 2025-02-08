package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollUtil {

    public static void scrollToElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniyelik bekleme süresi

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Elementin görünmesini bekle
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // Elementi ortala
        } catch (TimeoutException e) {
            System.out.println("Element bulunamadı veya görünür değil: " + locator);
        }

       // WebElement element = driver.findElement(locator); // Find the element
       // JavascriptExecutor js = (JavascriptExecutor) driver; // Create a JavascriptExecutor object
       // js.executeScript("arguments[0].scrollIntoView(true);", element); // Scroll to the element
        //
       // try {
       //     Thread.sleep(1000);
       // } catch (InterruptedException e) {
       //     e.printStackTrace();
       // }

    }

    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250);");
    }

    public static void scrollUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -250);");
    }

}