package tests;

import pages.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(OrderAnnotation.class)
public class TestCases extends BaseTest {

    private final HomePage homePage = new HomePage(driver);
    private final CompanyPage companyPage = new CompanyPage(driver);
    private final CareersPage careersPage = new CareersPage(driver);
    private final QAJobsPage qaJobsPage = new QAJobsPage(driver);
    private final OpenPositionsPage openPositionsPage = new OpenPositionsPage(driver);

    @Test
    @Order(1)
    public void testHomePageIsOpen() {
        homePage.open(); //Home page açılır
        assertTrue(homePage.isHomePageTitleDisplayed(), "Home page title does not contain 'insider' or the homepage element is not displayed."); // Sayfa başlığının 'insider' içerdiğini ve ana sayfanın görünür olduğunu doğrular
    }

    @Test
    @Order(2)
    public void testCareersPage() {
        companyPage.clickCompanyMenu(); // "Company" menüsüne tıklanır
        companyPage.clickCareersMenu(); // "Careers" menüsüne tıklanır

        // Careers sayfasının yüklenip yüklenmediği kontrol edilir
        assertTrue(careersPage.isLocationsBlockDisplayed(), "Locations block is not visible");
        assertTrue(careersPage.isTeamsBlockDisplayed(), "Teams block is not visible");
        assertTrue(careersPage.isLifeAtInsiderBlockDisplayed(), "Life at Insider block is not visible");
    }

    @Test
    @Order(3)
    public void tesQAJobsPage() {
        qaJobsPage.open(); // QA Jobs sayfası açılır
        qaJobsPage.clickSeeAllQaJobsButton(); // "See all QA jobs" butonuna tıklanır
        openPositionsPage.isPositionListItemDisplayed(); // Lokasyon dropdown'ı görünür olup olmadığı kontrol edilir
        openPositionsPage.validateDepartmentSelection("Quality Assurance"); // Departman kontrolü yapılır
        openPositionsPage.selectLocation("Istanbul, Turkiye"); // Lokasyon seçilir
    }

    @Test
    @Order(4)
    public void testJobApplication() {
        openPositionsPage.clickViewRoleButton(); // "View Role" butonuna tıklanır

        String originalWindow = driver.getWindowHandle(); // Mevcut pencerenin handle'ını al

        // Yeni pencereye geçiş yapılır ve URL kontrolü yapılır
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl(); // Mevcut URL'yi alınır
        assertTrue(currentUrl.contains("jobs.lever.co/useinsider"), "Yönlendirilen URL doğru değil: " + currentUrl);
    }

}