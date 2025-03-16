package TestNGPractice;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer{
	
	
	public void transform(ITestAnnotation anno, Class classs, Constructor c, Method m) {
		
		anno.setRetryAnalyzer(RetryAnalyzer.class);
		
		
		
	}
	
	
}