package TestsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.SearchContext; // Correct import for Shadow DOM handling
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ShadowDOMExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open real-time example website
        driver.get("https://books-pwakit.appspot.com/");

        // Step 1: Locate the Shadow Host
        WebElement shadowHost = driver.findElement(By.tagName("book-app"));

        // Step 2: Get Shadow Root (Use SearchContext instead of WebElement)
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        // Step 3: Find an element inside the Shadow DOM
        WebElement searchBox = shadowRoot.findElement(By.cssSelector("input#input"));

        // Step 4: Perform action on the shadow element
        searchBox.sendKeys("Selenium 4 Shadow DOM");

        System.out.println("Successfully interacted with a Shadow DOM element!");

        driver.quit();
        
        //or
     // Step 3: Use JavaScriptExecutor to access Shadow Root
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        // Find the Shadow Host (shop-app)
//        WebElement shadowHost = driver.findElement(By.tagName("shop-app"));
//
//        // Get the Shadow Root
//        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
//
//        // Step 4: Find a button inside Shadow DOM and click it
//        WebElement ironPages = shadowRoot.findElement(By.cssSelector("iron-pages"));
//        WebElement shadowChild = ironPages.findElement(By.tagName("shop-home"));
//        WebElement shadowRootChild = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowChild);
//
//        WebElement button = shadowRootChild.findElement(By.cssSelector("a[href='/list/mens_tshirts']"));
//        button.click();
//
//        System.out.println("Clicked on the 'Men's T-Shirts' link inside Shadow DOM!");
    }
}
