package tests;

import pages.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(OrderAnnotation.class) // OrderAnnotation is used to determine the order of the tests.
public class TestCases extends BaseTest {
    // Page objects are created
    private final HomePage homePage = new HomePage(driver);
    private final CompanyPage companyPage = new CompanyPage(driver);
    private final CareersPage careersPage = new CareersPage(driver);
    private final QAJobsPage qaJobsPage = new QAJobsPage(driver);
    private final OpenPositionsPage openPositionsPage = new OpenPositionsPage(driver);

    @Test
    @Order(1)
    public void testHomePageIsOpen() {
        homePage.open(); // The home page opens
        assertTrue(homePage.isHomePageTitleDisplayed(), "Home page title does not contain 'insider' or the homepage element is not displayed."); // Check if the home page title contains "insider"
    }

    @Test
    @Order(2)
    public void testCareersPage() {
        companyPage.clickCompanyMenu(); // Click the "Company" menu
        companyPage.clickCareersMenu(); // Click the "Careers" menu

        // Check if the Careers page elements are displayed
        assertTrue(careersPage.isLocationsBlockDisplayed(), "Locations block is not visible");
        assertTrue(careersPage.isTeamsBlockDisplayed(), "Teams block is not visible");
        assertTrue(careersPage.isLifeAtInsiderBlockDisplayed(), "Life at Insider block is not visible");
    }

    @Test
    @Order(3)
    public void tesQAJobsPage() throws InterruptedException {
        qaJobsPage.open(); // Open the QA Jobs page
        qaJobsPage.clickSeeAllQaJobsButton(); // Click the "See all QA jobs" button
        openPositionsPage.isPositionListItemDisplayed(); // Check if the position list item is displayed
        openPositionsPage.validateDepartmentSelection("Quality Assurance"); // Check if the department selection is correct
        openPositionsPage.selectLocation("Istanbul, Turkiye"); // Select the location
    }

    @Test
    @Order(4)
    public void testJobApplication() {
        openPositionsPage.hoverAndClickViewRoleButton(); // Click the "View role" button
        String originalWindow = driver.getWindowHandle(); // Get the original window handle

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle); // Switch to the new window
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl(); // Get the current URL
        assertTrue(currentUrl.contains("jobs.lever.co/useinsider"), "The redirected URL is not correct: " + currentUrl); // Check if the URL is correct
    }

}