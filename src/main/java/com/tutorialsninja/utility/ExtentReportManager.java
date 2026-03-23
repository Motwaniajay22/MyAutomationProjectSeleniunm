package com.tutorialsninja.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
