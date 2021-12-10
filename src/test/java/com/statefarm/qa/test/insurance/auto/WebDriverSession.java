package com.statefarm.qa.test.insurance.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;
import com.statefarm.qa.setup.BasePage;

public class WebDriverSession extends BasePage {

	@Test
	public void sessionCheck() {
		SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
		System.out.println(sessionId);
		BasePage.driver.get("https://www.amazon.com/");
		sessionId = ((RemoteWebDriver)driver).getSessionId();
		System.out.println("Amazon Session : "+sessionId);
		
		System.out.println(driver.findElement(By.xpath("(//input)[1]")).hashCode());
		
		WebElement element = driver.findElement(By.id("nav-search-submit-button"));
		element.click();
		
		System.out.println(driver.findElement(By.xpath("(//input)[1]")).hashCode());
	}
}
