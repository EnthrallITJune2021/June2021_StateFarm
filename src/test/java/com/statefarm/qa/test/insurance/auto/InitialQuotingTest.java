package com.statefarm.qa.test.insurance.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InitialQuotingTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/mdnas/OneDrive/Documents/Enthrall.IT/Projects/drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.statefarm.com/");
		
		WebElement element = driver.findElement(By.id("popDropdown"));
		element.click();
		
		Select productDropdown = new Select(element);
		productDropdown.selectByValue("Auto");
		
		element = driver.findElement(By.id("quote-main-zip-code-input"));
		element.click();
		element.sendKeys("11418");
		
		driver.findElement(By.id("quote-main-zip-btn")).click();
		
		Thread.sleep(5000);
		
		String text = driver.findElement(By.id("eyebrow")).getText();
		System.out.println(text);
		
		Assert.assertEquals(text, "STEP 1 OF 9");
		
		System.out.println("Test Passed....");
		
		driver.quit();
		
		
	}
}
