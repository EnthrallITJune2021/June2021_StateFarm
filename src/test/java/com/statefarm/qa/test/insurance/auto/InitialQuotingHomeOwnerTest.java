package com.statefarm.qa.test.insurance.auto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.statefarm.qa.autoPages.LandingPage;
import com.statefarm.qa.common.CommonMethods;
import com.statefarm.qa.setup.BasePage;

public class InitialQuotingHomeOwnerTest extends BasePage{
	
	LandingPage landingPage;
	CommonMethods commonMethods;
	
	@BeforeMethod
	public void initializationOfPages() {
		landingPage = new LandingPage(driver);
		commonMethods = new CommonMethods();
	}
	
	@Parameters({"product","zip"})
	@Test(groups = {"positive", "home"})
	public void verifyLandingPageHome(String product1, int zip1) {
		landingPage.landingPageSteps(commonMethods, product1, zip1);
	}

}
