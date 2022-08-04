package com.stepdefinition;

import java.io.FileNotFoundException; 
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.Login_Output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class LoginStep extends BaseClass {
	
	static Response response;
	static String logtoken;
	
	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept", "application/json");
	}

	@Given("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		basicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));
	}

	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String string) {
		response = requestType("POST", Endpoints.POSTMANAUTHLOGIN);
	}

	@Then("User should verify the login responsebody firstname present as {string} and get the logtoken")
	public void userShouldVerifyTheLoginResponsebodyFirstnamePresentAsAndGetTheLogtoken(String string) {
		Login_Output_pojo login_Output_pojo = response.as(Login_Output_pojo.class);
		logtoken = login_Output_pojo.getData().getLogtoken();
		String first_name = login_Output_pojo.getData().getFirst_name();
		System.out.println(first_name);
		Assert.assertEquals("verify firstname", string, first_name);
		
	}

}
