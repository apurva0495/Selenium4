package TestsClasses;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CustomExpectedConditionExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Custom condition: Wait for element to contain specific text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        boolean isTextUpdated = wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement element = driver.findElement(By.id("statusMessage"));
                return element.getText().contains("Success");
            }
        });
        System.out.println("Condition met: " + isTextUpdated);
        driver.quit();
    }
}
