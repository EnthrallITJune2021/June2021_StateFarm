package com.statefarm.qa.test.insurance.auto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.statefarm.qa.autoPages.FindAccountPage;
import com.statefarm.qa.autoPages.LandingPage;
import com.statefarm.qa.autoPages.LoginPage;
import com.statefarm.qa.autoPages.Step1Page;
import com.statefarm.qa.common.CommonMethods;
import com.statefarm.qa.setup.BasePage;

public class InitialQuotingAutoTest extends BasePage{
	
	CommonMethods commonMethods;
	LandingPage landingPage;
	Step1Page step1Page;
	LoginPage loginPage;
	FindAccountPage findAccountPage;
	
	@BeforeMethod
	public void pageInitialization() {
		commonMethods = new CommonMethods();
		landingPage = new LandingPage(driver);
		step1Page = new Step1Page(driver);
		loginPage = new LoginPage(driver);
		findAccountPage = new FindAccountPage(driver);
	}
	
	@Parameters({"product", "zip"})
	@Test(groups = {"positive", "auto"}, enabled = false)
	public void verifyStepsForNewCustomerAuto(String product, String zip) {
		landingPage.landingPageSteps(commonMethods, product, zip);
		step1Page.step1PageNewCustomerSteps(commonMethods, driver);
		System.out.println("Test 1 Passed..");
		//step2Page steps and validation
		//step3Page steps and validation
	}
	
	@Parameters("product")
	@Test(dependsOnGroups = {"positive", "auto"}, alwaysRun = false, ignoreMissingDependencies = true, enabled = true)
	public void verifyStepsForExistingCustomerAutoValidCred(String product) {
		landingPage.landingPageSteps(commonMethods, product, "11415");
		step1Page.step1PageExistingCustomerSteps(commonMethods);
		loginPage.loginPageSteps(commonMethods);
		System.out.println("Test 2 Passed..");
		//Existing customer flow
	}
	
	@Parameters("product")
	@Test(groups = {"negative", "auto"}, enabled = false)
	public void verifyFindAccountAuto(String product) {
		landingPage.landingPageSteps(commonMethods, product, "11418");
		step1Page.step1PageExistingCustomerSteps(commonMethods);
		loginPage.loginPageSteps(commonMethods);
		findAccountPage.findAccountSteps(commonMethods);
		System.out.println("Test 3 Passed..");
		//forgotten userId/pass pass flow
	}
}
