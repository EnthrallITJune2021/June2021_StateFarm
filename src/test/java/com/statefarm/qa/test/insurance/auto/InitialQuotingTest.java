package com.statefarm.qa.test.insurance.auto;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.statefarm.qa.auto.LandingPage;
import com.statefarm.qa.auto.Step1Page;
import com.statefarm.qa.base.BasePage;
import com.statefarm.qa.common.CommonMethods;

public class InitialQuotingTest extends BasePage{

	@BeforeMethod
	public void pageInitialization() {
		PageFactory.initElements(driver, LandingPage.class);
		PageFactory.initElements(driver, Step1Page.class);
	}
	
	@Test
	public void verifyLandingPage() {

		LandingPage.products.click();
		CommonMethods.dropDownSelectByValue(LandingPage.products, "Auto");
		LandingPage.zipCode.click();
		LandingPage.zipCode.sendKeys("11418");
		LandingPage.startAQuote.click();
		CommonMethods.waitUntilVisible(Step1Page.stepTitle, driver);
		Assert.assertEquals(CommonMethods.getText(Step1Page.stepTitle), "STEP 1 OF 9");
		
		
	}
}
