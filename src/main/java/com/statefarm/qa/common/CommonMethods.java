package com.statefarm.qa.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods {

	public void dropDownSelectByValue(WebElement element, String value) {
		Select productDropdown = new Select(element);
		productDropdown.selectByValue(value);
	}
	
	public String getText(WebElement element) {
		System.out.println(element.getText());
		return element.getText();
	}
	
	public void waitUntilVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void enterText(WebElement element, String zip) {
		element.sendKeys(zip);
	}
	
	public void enterText(WebElement element, int zip) {
		element.sendKeys(String.valueOf(zip));
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void assertEquals(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}
	
	public void clearText(WebElement element) {
		element.clear();
	}
}
