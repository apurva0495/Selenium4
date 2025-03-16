package TestsClasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HeadlessTest {
	
	WebDriver driver;
	@Test
	public void crossBrowserTest() throws IOException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		options.setAcceptInsecureCerts(true);
		driver=new ChromeDriver(options);
		driver.get("https://www.guru99.com/cross-browser-testing-using-selenium.html");
		driver.manage().window().maximize();
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenShots\\"+"image2.png"));

	}

}
