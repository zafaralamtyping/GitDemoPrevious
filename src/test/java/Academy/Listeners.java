package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtendReportsNG;

public class Listeners extends Base implements ITestListener{
	WebDriver driver;
	ExtentReports extentReports = ExtendReportsNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = extentReports.createTest(methodName);
		threadLocal.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		threadLocal.get().log(Status.PASS, "PASSED:");
		
	}

	public void onTestFailure(ITestResult result) {
		threadLocal.get().fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			
		}
		try {
			threadLocal.get().addScreenCaptureFromPath(getScreenShot(testMethodName, driver), testMethodName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
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
		extentReports.flush();
		
	}
	

}
