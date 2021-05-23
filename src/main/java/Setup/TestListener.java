package Setup;
import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	 File s1,s2;
	 
	 public void onTestStart(ITestResult res)
	 {
	 System.out.println("Started test case is "+ res.getName());
	 }
	 public void onStart(ITestContext res)
	 {
	 }
	 public void onFinish(ITestContext res)
	 {
	 }
	 // Run when the test case passed successfully
	 public void onTestSuccess(ITestResult res)
	 {
	 System.out.println("Test case passed is "+res.getName());
       
	 
	 }
	 // Run when the test case fails
	 public void onTestFailure(ITestResult res)
	 {
	 System.out.println("Test case failed is "+res.getName());
	 }
	 // Run when test case pass with some failures
	 public void onTestFailedButWithinSuccessPercentage(ITestResult res)
	 {
	 System.out.println("Test case passed with failure is "+res.getName());
	 }
	 // Run when the test case is skipped
	 public void onTestSkipped(ITestResult res)
	 {
	 System.out.println("Test case skipped is :"+res.getName());
	 }

}
