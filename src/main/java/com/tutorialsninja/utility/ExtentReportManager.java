package com.tutorialsninja.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/*public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getReportInstance() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timeStamp + ".html";

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setDocumentTitle("TutorialsNinja");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Application", "Tutorials Ninja");
		extent.setSystemInfo("Environment", "Local Host");
		extent.setSystemInfo("QA", System.getProperty("user.name"));
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Browser",
				System.getProperty("browser") != null ? System.getProperty("browser") : "Chrome");

		return extent;
	}

} */

public class ExtentReportManager {

	private static ExtentReports extent;

	// This is the ONLY method you call from Listener
	public static ExtentReports getReportInstance() {
		if (extent == null) { // Singleton, create only once
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timeStamp + ".html";

			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
			sparkReporter.config().setDocumentTitle("Automation Report");
			sparkReporter.config().setReportName("TutorialsNinja");
			sparkReporter.config().setTheme(Theme.DARK);

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);

			extent.setSystemInfo("Application", "Tutorials Ninja");
			extent.setSystemInfo("Environment", "Local Host");
			extent.setSystemInfo("QA", System.getProperty("user.name"));
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Java Version", System.getProperty("java.version"));
			extent.setSystemInfo("Browser",
					System.getProperty("browser") != null ? System.getProperty("browser") : "Chrome");
		}
		return extent;
	}
}

/*
 * public void onTestSuccess(ITestResult result) { test =
 * extent.createTest(result.getClass().getName());
 * test.assignCategory(result.getMethod().getGroups()); test.log(Status.PASS,
 * result.getName() + "Test Case PASSED is: "); }
 * 
 * public void onTestFailure(ITestResult result) { test =
 * extent.createTest(result.getClass().getName());
 * test.assignCategory(result.getMethod().getGroups()); test.log(Status.FAIL,
 * result.getName() + "test case FAILED"); test.log(Status.INFO,
 * result.getThrowable().getMessage());
 * 
 * try { String imgPath = new BaseClass().captureScreenShot(result.getName());
 * test.addScreenCaptureFromPath(imgPath); } catch (Exception e) {
 * e.printStackTrace(); }
 * 
 * }
 * 
 * public void onTestSkipped(ITestResult result) { test =
 * extent.createTest(result.getClass().getName());
 * test.assignCategory(result.getMethod().getGroups()); test.log(Status.SKIP,
 * result.getName() + " Got skipped"); test.log(Status.INFO,
 * result.getThrowable().getMessage());
 * 
 * }
 * 
 * public void onFinish(ITestContext context) {
 * 
 * extent.flush(); }
 * 
 * }
 */
