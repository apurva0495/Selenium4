package ExtentReporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseClass {
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setup() {
        // Initialize Extent Report and WebDriver
        extent = ExtentReportManager.getExtentReport();
        initializeDriver();
    }

    @Test
    public void validateGoogleSearch() {
        test = extent.createTest("Google Search Test", "Validate search functionality on Google");

        try {
            // Step 1: Navigate to Google
            test.log(Status.INFO, "Navigating to Google");
            driver.get("https://www.google.com");
            test.pass("Successfully navigated to Google");

            // Step 2: Perform search
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Extent Reports");
            searchBox.submit();
            test.info("Performed search for 'Extent Reports'");

            // Step 3: Validate results
            WebElement results = driver.findElement(By.id("search"));
            Assert.assertTrue(results.isDisplayed(), "Results are displayed");
            test.pass("Search results are displayed");

        } catch (Exception e) {
            String screenshotPath = Utilities.takeScreenshot(driver, "validateGoogleSearch");
            test.fail("Test failed due to exception: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver and flush the report
        tearDownDriver();
        extent.flush();
    }
}
