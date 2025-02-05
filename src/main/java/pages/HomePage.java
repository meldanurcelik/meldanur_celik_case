package pages;

import org.openqa.selenium.*;

public class HomePage {

    private final WebDriver driver;
    private final String URL = "https://useinsider.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public boolean isHomePageTitleDisplayed() {
        String homePageTitle = driver.getTitle();
        return homePageTitle.contains("Insider");
    }

}