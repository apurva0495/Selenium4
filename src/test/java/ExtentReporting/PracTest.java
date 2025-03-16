package ExtentReporting;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class PracTest {
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	@Test
	public void testss() {
		report=new ExtentReports();
		ExtentSparkReporter r=new ExtentSparkReporter("TestRepo.html");
		r.config().setReportName("This is report");
		
		report.attachReporter(r);
		report.setSystemInfo("Env", "QA");
		test=report.createTest("This is first test");
		test.pass("This is passed");
		report.flush();
		
	}

}
