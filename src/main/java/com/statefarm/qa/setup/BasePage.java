package com.statefarm.qa.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {

	public static WebDriver driver;
	
	@BeforeMethod
	public WebDriver setUpDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.statefarm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
