package TestsClasses;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class CustomFluentWaitExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Create FluentWait instance
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20)) // Max wait time
                .pollingEvery(Duration.ofSeconds(2)) // Polling interval
                .ignoring(NoSuchElementException.class); // Ignore exceptions

        // Custom condition: Wait for element to be visible
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement el = driver.findElement(By.id("targetElement"));
                if (el.isDisplayed()) {
                    return el;
                } else {
                    return null;
                }
            }
        });

        element.click(); // Perform action

        driver.quit();
    }
}
