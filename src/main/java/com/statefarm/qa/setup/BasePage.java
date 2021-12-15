package com.statefarm.qa.setup;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.statefarm.qa.reporting.ExtentManager;
import com.statefarm.qa.reporting.ExtentTestManager;
import com.statefarm.qa.reporting.TestLogger;
import com.statefarm.qa.utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;
	public static ExtentReports extent;

	@BeforeSuite
	public void initiateReporting() {
		extent = ExtentManager.getInstance();
	}

	@BeforeMethod
	public WebDriver setUpDriver() throws MalformedURLException {
		// loadDriver();
		// loadWebDriverManager();
		remoteWebDriver();
		// driver = new ChromeDriver();
		String url = ReadProperties.instanceOFProp().getURL();
		driver.get(url);
		driver.manage().window().maximize();
		int pageLoadTtime = ReadProperties.instanceOFProp().getPageLoadTime();
		int implicitLoadTime = ReadProperties.instanceOFProp().getImplicitLoadTime();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitLoadTime, TimeUnit.SECONDS);
		return driver;
	}

	public void remoteWebDriver() throws MalformedURLException {
		//MutableCapabilities sauceOptions = new MutableCapabilities();
		//sauceOptions.setCapability("username", "oauth-md.nasiribnehussain-b2550");
		//sauceOptions.setCapability("accessKey", "ee4fa700-9d36-4bad-8cdc-e091971b0046");

		DesiredCapabilities browserOptions = new DesiredCapabilities();
		browserOptions.setCapability("platformName", "macOS 12");
		browserOptions.setCapability("browserVersion", "latest");
		browserOptions.setCapability("browserName", "chrome");
		//browserOptions.setCapability("sauce:options", sauceOptions);
		URL url = new URL("https://oauth-md.nasiribnehussain-b2550:ee4fa700-9d36-4bad-8cdc-e091971b0046@ondemand.us-west-1.saucelabs.com:443/wd/hub");
				//new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");

		driver = new RemoteWebDriver(url, browserOptions);
	}

	public void loadDriver() {
		String currentOS = System.getProperty("os.name");
		if (currentOS.startsWith("Win")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		} else if (currentOS.startsWith("Mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		}
	}

	public void loadWebDriverManager() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeMethod()
	public void startExtent(Method method, Object[] testData) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManager.startTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);
	}

	protected String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}

	@AfterMethod
	public void afterEachTestMethod(ITestResult result) throws Exception {
		for (String group : result.getMethod().getGroups()) {
			ExtentTestManager.getTest().assignCategory(group);
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(Status.FAIL, getStackTrace(result.getThrowable()));
			String ss = CaptureScreenShot(result.getName());
			ExtentTestManager.getTest().addScreenCaptureFromPath(ss);
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		}
		driver.quit();
	}

	@AfterSuite
	public void finishReporting() {
		extent.flush();
	}

	public static String CaptureScreenShot(String ssName) {
		DateFormat dFormat = new SimpleDateFormat("MM.dd.yyyy HH.mm.ss");
		Date date = new Date();
		String postDate = dFormat.format(date);

		File screenShotLocation = new File("screenShots/" + ssName + "_" + postDate + ".png");
		File screenShotSrc = ((org.openqa.selenium.TakesScreenshot) driver)
				.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		try {
			Files.copy(screenShotSrc, new File(screenShotLocation.getAbsolutePath()));
			System.out.println("Error occured!!! \nScreen Shot Captured");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		TestLogger.log("Error Screen Shot has been saved at : ", screenShotLocation.getPath());
		return screenShotLocation.getAbsolutePath();
	}
}
