package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;

import cucumber.api.java.en.Then;

public class CommonStep extends BaseClass {

	@Then("User should verify the status code is {int}")
	public void userShouldVerifyTheStatusCodeIs(Integer int1) {
		
		int statusCode = getStatusCode(LoginStep.response);
		System.out.println(statusCode);	
		
		Assert.assertEquals("verify status code", 200, statusCode);
	}
	
}
