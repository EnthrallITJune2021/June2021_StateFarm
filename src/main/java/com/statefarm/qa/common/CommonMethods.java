package com.statefarm.qa.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.statefarm.qa.reporting.TestLogger;
import com.statefarm.qa.setup.BasePage;

public class CommonMethods {

	public void dropDownSelectByValue(WebElement element, String value) {
		Select productDropdown = new Select(element);
		productDropdown.selectByValue(value);
		TestLogger.log("Dropdown value is :" + value);
	}
	
	public String getText(WebElement element) {
		TestLogger.log("WebElement text is :" + element.getText());
		return element.getText();
	}
	
	public void waitUntilVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BasePage.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		TestLogger.log("Waiting for the element");
	}
	
	public void enterText(WebElement element, String zip) {
		element.sendKeys(zip);
		TestLogger.log("Entering text is : " + zip);
	}
	
	public void enterText(WebElement element, int zip) {
		element.sendKeys(String.valueOf(zip));
		TestLogger.log("Entering text is : " + zip);
	}
	
	public void click(WebElement element) {
		element.click();
		TestLogger.log("Clicking... " + element.getText());
	}
	
	public void assertEquals(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}
	
	public void clearText(WebElement element) {
		element.clear();
		TestLogger.log("Clearing... " + element.getText());
	}
	
	public void hoverOnly(WebElement element) {
		Actions actions = new Actions(BasePage.driver);
		actions.moveToElement(element).build().perform();
		TestLogger.log("Hover Over on " + element.getText());
	}
	
	public void hoverAndClick(WebElement element) {
		Actions actions = new Actions(BasePage.driver);
		actions.moveToElement(element).click().perform();
		TestLogger.log("Hover Over and click on " + element.getText());
	}
}
