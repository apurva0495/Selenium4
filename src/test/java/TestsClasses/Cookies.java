package TestsClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Cookies {

	WebDriver driver;
	@Test
	public void crossBrowserTest() throws IOException {
		
		driver=new ChromeDriver();
		driver.get("https://www.guru99.com/cross-browser-testing-using-selenium.html");
		driver.manage().window().maximize();
		Set<Cookie> cookie=driver.manage().getCookies();
		for(Cookie c:cookie) {
			System.out.println(c.getName()+"---------- "+c.getValue());
		}
		driver.manage().deleteAllCookies();
		Cookie newCookie = new Cookie("user", "testUser");
		driver.manage().addCookie(newCookie);
		
		driver.manage().deleteCookie(newCookie);
		
		

	}


}
