package com.statefarm.qa.reporting;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/*
 * This calss will keep track of the current thread for each test
 */

public class ExtentTestManager {

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	private static ExtentReports extent = ExtentManager.getInstance();

	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	/*
	 * public static synchronized void endTest() {
	 * extent.endTest(extentTestMap.get((int) (long)
	 * (Thread.currentThread().getId()))); }
	 */

	public static synchronized ExtentTest startTest(String testName) {
		return startTest(testName, "");
	}

	/*
	 * public static synchronized ExtentTest startTestClass(String className, String
	 * testName) { return startTest(className, testName, ""); }
	 */

	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.createTest(testName, desc);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

	/*
	 * public static synchronized ExtentTest startTest(String className, String
	 * testName, String desc) { ExtentTest test = extent.createTest(testName, desc);
	 * extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
	 * return test; }
	 */
}
