package ExtentReporting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    protected static WebDriver driver;

    public static void initializeDriver() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\BrowerDrivers\\chromedriver.exe");
		driver =new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
