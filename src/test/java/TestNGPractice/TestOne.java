package TestNGPractice;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestOne {
	
	@Test()
	public void A() {
	    System.out.println("Soft");
	    
	    Assert.assertTrue(false);
	    
	}
	
	
	
	

}
