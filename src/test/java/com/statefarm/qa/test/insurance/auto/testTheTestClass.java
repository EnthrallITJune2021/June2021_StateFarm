package com.statefarm.qa.test.insurance.auto;

import org.testng.annotations.Test;

public class testTheTestClass {

	@Test(groups = {"positive", "generic"}, priority = 0)
	public void aTest() {
		System.out.println("..........\nA Test From another class");
	}
	
	@Test(groups = {"negative", "generic"}, invocationCount = 3)
	public void secondTest() {
		System.out.println(".........\n Second Test from another class");
	}
	
	@Test(groups = {"positive", "generic"}, enabled = true)
	public void thirdTest() {
		System.out.println(".........\n Third Test from another class");
	}
}
