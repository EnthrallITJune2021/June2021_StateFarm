package com.statefarm.qa.test.insurance.auto;

import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.statefarm.qa.autoPages.FindAccountPage;
import com.statefarm.qa.autoPages.LandingPage;
import com.statefarm.qa.autoPages.LoginPage;
import com.statefarm.qa.autoPages.Step1Page;
import com.statefarm.qa.common.CommonMethods;
import com.statefarm.qa.setup.BasePage;
import com.statefarm.qa.utils.Details;
import com.statefarm.qa.utils.ReadProperties;

public class InitialQuotingAutoTest extends BasePage{
	
	@DataProvider (name = "personalDetails")
	public Iterator<Details> getList(){
		ArrayList<Details> list = new ArrayList<Details>();
		list.add(new Details("john", "henry", "doe", "Sr", "8786 Lefferts Blvd", "2B", "Richmond hill", "11418", "10/12/1855"));
		list.add(new Details("simon", "henry", "collins", "Jr", "8787 Lefferts Blvd", "6C", "Richmond hill", "11418", "10/12/2000"));
		list.add(new Details("Jen", "alic", "doe", "Sr", "8788 Lefferts Blvd", "7F", "Richmond hill", "11418", "10/12/1988"));
		return list.iterator();
	}
	
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
	
	@Test(dataProvider = "personalDetails", groups = {"positive", "auto"}, enabled = true)
	public void verifyStepsForNewCustomerAuto(Details details) {
		landingPage.landingPageSteps(commonMethods, "Auto", "11418");
		step1Page.step1PageNewCustomerDetailsSteps(commonMethods, details);
		System.out.println("Test 1 Passed..");
		//step2Page steps and validation
		//step3Page steps and validation
	}
	
	@Parameters("product")
	@Test(dependsOnGroups = {"positive", "auto"}, alwaysRun = false, ignoreMissingDependencies = true, enabled = false)
	public void verifyStepsForExistingCustomerAutoValidCred(String product) {
		landingPage.landingPageSteps(commonMethods, product, "11415");
		step1Page.step1PageExistingCustomerSteps(commonMethods);
		loginPage.loginPageSteps(commonMethods, ReadProperties.instanceOFProp().getUsername(), ReadProperties.instanceOFProp().getPassword());
		System.out.println("Test 2 Passed..");
		//Existing customer flow
	}
	
	@Parameters("product")
	@Test(groups = {"negative", "auto"}, enabled = false)
	public void verifyFindAccountAuto(String product) {
		landingPage.landingPageSteps(commonMethods, product, "11418");
		step1Page.step1PageExistingCustomerSteps(commonMethods);
		loginPage.loginPageSteps(commonMethods, ReadProperties.instanceOFProp().getUsername(), ReadProperties.instanceOFProp().getPassword());
		findAccountPage.findAccountSteps(commonMethods);
		System.out.println("Test 3 Passed..");
		//forgotten userId/pass pass flow
	}
	
}
