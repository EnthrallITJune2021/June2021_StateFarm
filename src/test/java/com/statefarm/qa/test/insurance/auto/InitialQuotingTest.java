package com.statefarm.qa.test.insurance.auto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.statefarm.qa.autoPages.FindAccountPage;
import com.statefarm.qa.autoPages.LandingPage;
import com.statefarm.qa.autoPages.LoginPage;
import com.statefarm.qa.autoPages.Step1Page;
import com.statefarm.qa.common.CommonMethods;
import com.statefarm.qa.setup.BasePage;

public class InitialQuotingTest extends BasePage{
	
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
	
	@Test
	public void verifyStepsForNewCustomerAuto() {
		landingPage.landingPageSteps(commonMethods);
		step1Page.step1PageNewCustomerSteps(commonMethods, driver);
		//step2Page steps and validation
		//step3Page steps and validation
	}
	
	@Test
	public void verifyStepsForExistingCustomerAutoValidCred() {
		landingPage.landingPageSteps(commonMethods);
		step1Page.step1PageExistingCustomerSteps(commonMethods);
		loginPage.loginPageSteps(commonMethods);
		//Existing customer flow
	}
	
	@Test
	public void verifyFindAccountAuto() {
		landingPage.landingPageSteps(commonMethods);
		step1Page.step1PageExistingCustomerSteps(commonMethods);
		loginPage.loginPageSteps(commonMethods);
		findAccountPage.findAccountSteps(commonMethods);
		//forgotten userId/pass pass flow
	}
}
