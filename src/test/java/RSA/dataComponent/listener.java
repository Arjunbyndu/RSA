package RSA.dataComponent;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import RSA.abstractClass.extentReportp1;

public class listener extends basetestp1 implements ITestListener{

	ExtentReports extent =extentReportp1.reportsp1();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "yes passed");
	}

	public void onTestFailure(ITestResult result) {
		extenttest.get().fail(result.getThrowable());
		// Initializing driver to ss
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//locating path and creating screen shot
		String path =null;
		try {
			path = screenshot(result.getMethod().getMethodName() , driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		extenttest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
