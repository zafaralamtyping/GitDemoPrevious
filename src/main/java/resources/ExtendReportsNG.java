package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportsNG {
	static ExtentReports extentReports;
	
	public static ExtentReports getReportObject() {
		String destinationPath = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(destinationPath);
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		return extentReports;
	}

}
