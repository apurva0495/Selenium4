package TestNGPractice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	
	
	private int a=0;
	private int max=5;
	public boolean retry(ITestResult result) {
		if(a<max) {
			a++;
			return true;
		}
		return false;
	}
}
