# Test Automation for Insider Website (Java + Selenium)

This repository contains an automation test case for the Insider website, developed using Java and Selenium WebDriver. The test case ensures the correct functionality of specific pages and actions on the website, and it has been tested on Chrome, and Firefox.

🛠 Requirements

- Java 8 or higher

- Selenium WebDriver

- ChromeDriver, GeckoDriver (for Firefox)

- Maven (for dependency management)

📌 Test Steps

The test case includes the following steps:

1. Homepage Validation: Verify that the Insider homepage opens correctly.

2. Navigation to Careers Page: Check if the "Careers" page can be accessed from the "Company" menu, and validate the presence of blocks: Locations, Teams, and Life at Insider.

3. Job Listings Validation: Go to the Quality Assurance careers page, click on "See all QA jobs", filter by Location ("Istanbul, Turkey") and Department ("Quality Assurance"), and validate that job listings are displayed.

4. Job Details Validation: Ensure that each job listing contains the correct Position, Department, and Location.

5. Redirection to Application Form: Click the “View Role” button and verify that it redirects to the Lever application form.

📊 Failure Screenshot

If any of the steps fail during the test execution, a screenshot will be captured and stored in the screenshots/ directory.

