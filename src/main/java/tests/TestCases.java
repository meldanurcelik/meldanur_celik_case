package tests;

import pages.HomePage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCases extends BaseTest {

    @Test
    public void testHomePageIsOpen() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        assertTrue(homePage.isHomePageTitleDisplayed(), "Home page title does not contain 'insider' or the homepage element is not displayed.");
    }

}