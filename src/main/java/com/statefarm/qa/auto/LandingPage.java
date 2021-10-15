package com.statefarm.qa.auto;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	@FindBy(id = "popDropdown")
	public static WebElement products;
	@FindBy(id = "quote-main-zip-code-input")
	public static WebElement zipCode;
	@FindBy(id = "quote-main-zip-btn")
	public static WebElement startAQuote;
}
