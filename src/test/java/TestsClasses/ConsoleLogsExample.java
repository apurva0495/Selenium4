package TestsClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.LogType;

import java.util.logging.Level;

public class ConsoleLogsExample {
    public static void main(String[] args) {
        // Enable logging
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:loggingPrefs", logPrefs);

        // Launch browser
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.guru99.com/cross-browser-testing-using-selenium.html");

        // Capture console logs
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logs) {
            System.out.println(entry.getLevel() + " " + entry.getMessage());
        }

        // Close browser
        driver.quit();
    }
}
