package com.mygithublab;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseBrowser;
import resources.ExtentReporterNG;

public class Listeners extends BaseBrowser implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getExtentReportsObj();
	ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		threadExtentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Passed test name : " + result.getName());
		threadExtentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// System.out.println("Failed test name : " + result.getName());
		
		// -----------  Updated Screenshot code ----------------
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		threadExtentTest.get().fail(result.getThrowable());
		
		// Following line of code gives access to the field of any class
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			threadExtentTest.get().addScreenCaptureFromPath(getScreenshots(testMethodName,driver), testMethodName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// -----------  Old Screenshot code ----------------
		/*
		  try {
		 
			base.getScreenshots(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
	}

}
