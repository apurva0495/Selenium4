package TestsClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AJAXClass {

	WebDriver driver;
	
	public void waitForPageLoad() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(driver -> ((JavascriptExecutor) driver)
	            .executeScript("return document.readyState").equals("complete"));
	}
	
	public void waitForAjaxToComplete() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    wait.until(driver -> (Boolean) ((JavascriptExecutor) driver)
	            .executeScript("return jQuery.active == 0"));
	}
	@Test
	public void crossBrowserTest() throws IOException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		options.setAcceptInsecureCerts(true);
		driver=new ChromeDriver(options);
		driver.get("https://www.guru99.com/cross-browser-testing-using-selenium.html");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajaxElement")));
		element.click();
		
		
		Wait<WebDriver> waits=new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class);
		
		WebElement elements = waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajaxElement")));
		elements.click();
		 
		 
	}
}
