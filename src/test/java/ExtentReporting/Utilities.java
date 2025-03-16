package ExtentReporting;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utilities {
    public static String takeScreenshot(WebDriver driver, String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = "screenshots/" + testName + ".png";
        try {
            FileUtils.copyFile(screenshot, new File(filePath));
        } catch (IOException e) {
            System.out.println("Unable to save screenshot: " + e.getMessage());
        }
        return filePath;
    }
}
