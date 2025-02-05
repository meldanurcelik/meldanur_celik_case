package utils;

import org.openqa.selenium.*;

public class ScrollUtil {

    public static void scrollToElement(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);

        // JavascriptExecutor kullanarak kaydırma işlemi yapılır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // Elementin üzerine tıklama işlemi veya başka işlemler yapılmadan önce biraz beklemek faydalı olabilir
        try {
            Thread.sleep(2000); // Kaydırma sonrası biraz bekle (opsiyonel)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollDown(WebDriver driver) {
        // Sayfayı aşağıya kaydırmak için
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250);");
    }

    public static void scrollUp(WebDriver driver) {
        // Sayfayı yukarıya kaydırmak için
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -250);");
    }
}