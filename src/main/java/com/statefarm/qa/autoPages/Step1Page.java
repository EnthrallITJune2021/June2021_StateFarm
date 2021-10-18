package com.statefarm.qa.autoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.statefarm.qa.common.CommonMethods;

public class Step1Page {

	public Step1Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "eyebrow")
	public WebElement stepTitle;
	@FindBy(id = "btnExisting")
	public WebElement existingCustomer;
	@FindBy(id = "first_name")
	public WebElement firstName;
	@FindBy(id = "middle_name")
	public WebElement middleName;
	@FindBy(id = "last_name")
	public WebElement lastName;
	@FindBy(id = "suffix_name-button")
	public WebElement suffixButton;
	@FindBy(id = "suffix_name")
	public WebElement suffixName;
	@FindBy(id = "street1")
	public WebElement street;
	@FindBy(id = "street2")
	public WebElement aptNo;
	@FindBy(id = "city")
	public WebElement city;
	@FindBy(id = "zipPostalCode")
	public WebElement zipCode;
	@FindBy(id = "date_of_birth")
	public WebElement DOB;
	@FindBy(id = "effectiveDate")
	public WebElement effectiveDate;
	@FindBy(id = "btnContinue")
	public WebElement continueButton;
	
	public void step1PageNewCustomerSteps(CommonMethods commonMethods, WebDriver driver) {
		commonMethods.waitUntilVisible(stepTitle, driver);
		commonMethods.assertEquals(commonMethods.getText(stepTitle), "STEP 1 OF 9");
		commonMethods.enterText(firstName, "John");
		commonMethods.enterText(middleName, "M");
		commonMethods.enterText(lastName, "Doe");
		commonMethods.click(suffixButton);
		commonMethods.click(clickSuffix("Sr", driver));
		commonMethods.enterText(street, "8888 Lefferts Blvd");
		commonMethods.enterText(aptNo, "4A");
		commonMethods.clearText(city);
		commonMethods.enterText(city, "South Ozone Park");
		commonMethods.clearText(zipCode);
		commonMethods.enterText(zipCode, "11418");
		commonMethods.enterText(DOB, "10/15/2000");
		commonMethods.clearText(effectiveDate);
		commonMethods.enterText(effectiveDate, "10/25/2021");
		commonMethods.click(continueButton);
	}
	
	public void step1PageExistingCustomerSteps(CommonMethods commonMethods) {
		commonMethods.click(existingCustomer);
	}
	
	public WebElement clickSuffix(String expectedSuffix, WebDriver driver) {
		return driver.findElement(By.xpath("//li[contains(.,'"+ expectedSuffix +"')]"));
	}
}
