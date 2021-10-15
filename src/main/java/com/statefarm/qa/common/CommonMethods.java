package com.statefarm.qa.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	public static void dropDownSelectByValue(WebElement element, String value) {
		Select productDropdown = new Select(element);
		productDropdown.selectByValue(value);
	}
	
	public static String getText(WebElement element) {
		System.out.println(element.getText());
		return element.getText();
	}
	
	public static void waitUntilVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
