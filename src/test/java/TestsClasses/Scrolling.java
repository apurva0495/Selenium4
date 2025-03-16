package TestsClasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scrolling {

	WebDriver driver;
	@Test
	public void crossBrowserTest() throws IOException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		options.setAcceptInsecureCerts(true);
		driver=new ChromeDriver(options);
		driver.get("https://www.guru99.com/cross-browser-testing-using-selenium.html");
		driver.manage().window().maximize();
		JavascriptExecutor  js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
		
		JavascriptExecutor  jss=(JavascriptExecutor)driver;
		jss.executeScript("window.scrollBy(0,-500);");
		
		JavascriptExecutor  jsss=(JavascriptExecutor)driver;
		jsss.executeScript("window.scrollBy(200,500);");
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		 WebElement element = driver.findElement(By.id("elementId")); 
		js.executeScript("arguments[0].scrollIntoView()",element);
		
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		
		
	}

}
