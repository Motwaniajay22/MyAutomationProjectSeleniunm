package com.tutorialsninja.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.base.BaseClass;
import com.tutorialsninja.utility.ExtentReportManager;

public class MyListeners implements ITestListener {
	private static ExtentReports extent = ExtentReportManager.getReportInstance();

	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + "Test Case PASSED is: ");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + "test case FAILED");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgPath =  BaseClass.captureScreenShot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " Got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
