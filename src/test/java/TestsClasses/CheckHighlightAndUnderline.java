package TestsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckHighlightAndUnderline {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        // Open Wikipedia page
        driver.get("https://en.wikipedia.org/wiki/Selenium_(software)"); 
        
        // Locate a hyperlink (underlined text example)
        WebElement linkElement = driver.findElement(By.xpath("//a[contains(text(), 'WebDriver')]")); 
        
        // Get the background color (for highlighting)
        String backgroundColor = linkElement.getCssValue("background-color");

        // Get the text decoration (for underline)
        String textDecoration = linkElement.getCssValue("text-decoration");
        
     // Check if the text is highlighted and underlined
        boolean isHighlighted = !backgroundColor.equals("rgba(0, 0, 0, 0)") && !backgroundColor.equals("transparent");
        boolean isUnderlined = textDecoration.contains("underline");
        if (isHighlighted && isUnderlined) {
            System.out.println("The text is highlighted and underlined.");
        } else if (isUnderlined) {
            System.out.println("The text is underlined but not highlighted.");
        } else if (isHighlighted) {
            System.out.println("The text is highlighted but not underlined.");
        } else {
            System.out.println("The text is neither highlighted nor underlined.");
        }

        // Close the browser
        
    }
}
