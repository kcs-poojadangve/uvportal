package org.uvportal.utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter{
	
	public  ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/myReport.html");
		reporter.config().setDocumentTitle("APITesting");
		 reporter.config().setReportName("Sample Extent Report");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "localHost");
		extent.setSystemInfo("Enviornment", "QA");
		extent.setSystemInfo("user", "pooja");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case passed is " +result.getName());
	}
	
	public void onTestFailed(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case failed is " +result.getName());
		test.log(Status.FAIL, "Test case is failed " +result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case skipped is " +result.getName());
	}
	
	public void onFinished(ITestContext testContext)
	{
		extent.flush();
	}
}
