package TestsClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Waitss {
	
	WebDriver driver;
	@Test
	public void crossBrowserTest() throws IOException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		options.setAcceptInsecureCerts(true);
		driver=new ChromeDriver(options);
		driver.get("https://www.guru99.com/cross-browser-testing-using-selenium.html");
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicElement")));
		element.click();
		
		Wait<WebDriver> waits=new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(5000))
				.pollingEvery(Duration.ofSeconds(1000))
				.ignoring(NoSuchElementException.class);
		
		
		WebElement ele=waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
		
		WebElement eles=waits.until(new Function<WebDriver,WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(""));
			}
			 
		});
		

	}

}
