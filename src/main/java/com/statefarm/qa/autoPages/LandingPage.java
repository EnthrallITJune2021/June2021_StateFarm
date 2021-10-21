package com.statefarm.qa.autoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.statefarm.qa.common.CommonMethods;

public class LandingPage {

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "popDropdown")
	public WebElement products;
	@FindBy(id = "quote-main-zip-code-input")
	public WebElement zipCode;
	@FindBy(id = "quote-main-zip-btn")
	public WebElement startAQuote;
	
	public void landingPageSteps(CommonMethods commonMethods, String product, String zip) {
		commonMethods.dropDownSelectByValue(products, product);
		commonMethods.enterText(zipCode, zip);
		commonMethods.click(startAQuote);
	}
	
	public void landingPageSteps(CommonMethods commonMethods, String product, int zip) {
		commonMethods.dropDownSelectByValue(products, product);
		commonMethods.enterText(zipCode, zip);
		commonMethods.click(startAQuote);
	}
}
