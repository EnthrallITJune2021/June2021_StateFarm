package com.statefarm.qa.reporting;

import org.testng.Reporter;
import com.aventstack.extentreports.Status;

/*
 * TestLogger class is basically log information in the reporting file - Extent report
 */

public class TestLogger {

	public static void log(final String message) {
		Reporter.log(message, true);
		ExtentTestManager.getTest().log(Status.INFO, message + "<br>");
	}

	public static void log(final String message, final String message2) {
		Reporter.log(message + message2, true);
		ExtentTestManager.getTest().log(Status.INFO, message + message2 + "<br>");
	}

}
