package com.practice.utilities;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.practice.base.BaseClass;


public class ListenersClass implements ITestListener {
	
	private static ExtentReports extent;
	private static ExtentTest  test;
	
	//initialize  logs
	static {
		    // Initialize Log4j
		    DOMConfigurator.configure("logs4j.xml");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
        Logs4j.info("Test started: " + result.getMethod().getMethodName());
		;
        
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		Logs4j.info("Test passed: " + result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result) {
		 test.log(Status.FAIL, "Test Failed");
		 Logs4j.error("Test failed: " + result.getMethod().getMethodName());

	        WebDriver driver = null;
			driver = BaseClass.getDriver();
			 if (driver != null) {
		            TakesScreenshot ts = (TakesScreenshot) driver;
		            String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";
		            try {
		                File src = ts.getScreenshotAs(OutputType.FILE);
		                Files.copy(src.toPath(), Paths.get(screenshotPath));
		                test.addScreenCaptureFromPath(screenshotPath, result.getName());
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
	}
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped");
		Logs4j.warn("Test skipped: " + result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReports/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
		
	}

	
}
