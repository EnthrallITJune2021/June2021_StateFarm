package com.statefarm.qa.reporting;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 * This class will setup the base for Extent Reporting
 */

public class ExtentManager {

	private static ExtentReports extent;

	public synchronized static ExtentReports getInstance() {
		if (extent == null) {
			try {
				extent = new ExtentReports();
				String fileName = new SimpleDateFormat("MMddyyyy_hhmm_").format(new Date());
				ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReports/ExtentReport"+fileName+".html");
				extentSparkReporter.config().setReportName("State Farm Automation");
				extent.attachReporter(extentSparkReporter);
				System.out.println("Reporting is started");
				extent.setSystemInfo("Testing Team", "QA Team");
				extent.setSystemInfo("Environment", "QA");
				extent.setSystemInfo("Test Name", "StateFarm Test");
			} catch (Exception e) {
				System.out.println(e.getMessage() + "\n" + "Exception while generating report");
			}
		}

		return extent;
	}
}
