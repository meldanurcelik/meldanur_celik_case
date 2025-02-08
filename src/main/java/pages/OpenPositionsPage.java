package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.time.Duration;

import static utils.ScrollUtil.scrollToElement;

public class OpenPositionsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By careerPositionList = By.xpath("//section[@id='career-position-list']");
    private final By careerPositionItem = By.xpath("(//section[@id='career-position-list']//p[@class='position-title font-weight-bold'])[1]");
    private final By filterByLocationDropdown = By.xpath("//span[@id='select2-filter-by-location-container']");
    private final By filterByDepartmentDropdown = By.xpath("//span[@id='select2-filter-by-department-container']");
    private final By roleButtonXpath = By.xpath("(//a[contains(text(),'View Role')])[1]");

    public OpenPositionsPage(WebDriver driver) {
        this.driver = driver; // WebDriver'ı başlatır
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 saniyelik dinamik bekleme süresi
    }

    public boolean isPositionListItemDisplayed() {
        try {
            scrollToElement(driver, careerPositionList);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(careerPositionItem));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectLocation(String location) {
        // Scroll işlemiyle dropdown'a kaydırma yapılır
        //scrollToElement(driver, careerPositionList);
        WebElement filterDropdown = driver.findElement(filterByLocationDropdown);
        filterDropdown.click();

        // Seçilecek lokasyonun XPath'ini belirle
        By locationOption = By.xpath("//li[text()='" + location + "']");
        wait.until(ExpectedConditions.elementToBeClickable(locationOption)).click();
    }

    public void validateDepartmentSelection(String department) {
        // 'Quality Assurance' seçiminin seçili olup olmadığını kontrol etmek
        WebElement filterDropdown = driver.findElement(filterByDepartmentDropdown);
        String selectedText = filterDropdown.getText();

        if (selectedText.equals(department)) {
            System.out.println(department + " is selected.");
        } else {
            System.out.println(department + " is not selected.");
        }
    }

    public void clickViewRoleButton() {
        WebElement viewRoleButton = driver.findElement(roleButtonXpath);
        viewRoleButton.click();
    }

    public void hoverAndClickViewRoleButton() {
        List<WebElement> viewRoleButtons = driver.findElements(roleButtonXpath);
        if (!viewRoleButtons.isEmpty()) {
            Actions actions = new Actions(driver);
            WebElement button = viewRoleButtons.get(0);
            actions.moveToElement(button).click().perform();
        }
    }

}