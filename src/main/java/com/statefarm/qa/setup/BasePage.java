package com.statefarm.qa.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.statefarm.qa.utils.ReadProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;
	
	@BeforeMethod
	public WebDriver setUpDriver() {
		//loadDriver();
		loadWebDriverManager();
		driver = new ChromeDriver();
		String url = ReadProperties.instanceOFProp().getURL();
		driver.get(url);
		driver.manage().window().maximize();
		int pageLoadTtime = ReadProperties.instanceOFProp().getPageLoadTime();
		int implicitLoadTime = ReadProperties.instanceOFProp().getImplicitLoadTime();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitLoadTime, TimeUnit.SECONDS);
		return driver;
	}
	
	public void loadDriver() {
		String currentOS = System.getProperty("os.name");
		if(currentOS.startsWith("Win")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		} else if(currentOS.startsWith("Mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		}
	}
	
	public void loadWebDriverManager() {
		WebDriverManager.chromedriver().setup();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
