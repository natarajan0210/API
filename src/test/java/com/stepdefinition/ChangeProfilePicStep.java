package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.units.qual.m;
import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.ChangeProfilePic_Output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class ChangeProfilePicStep extends BaseClass {

	String logtoken;
	String valueOf;
	static Response response;

	@Given("User add headers and bearer authorizaton for accessing change profile pic endpoints")
	public void userAddHeadersAndBearerAuthorizatonForAccessingChangeProfilePicEndpoints() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		addHeaders(h);

	}

	@When("User add multipart form data for change profile pic")
	public void userAddMultipartFormDataForChangeProfilePic() {

		formData();
	}

	@When("User send {string} request for change profile pic")
	public void userSendRequestForChangeProfilePic(String string) {

		response = requestType("POST", Endpoints.CHANGEPROFILEPIC);
	}

	@Then("User should verify the change profile pic response message matches {string}")
	public void userShouldVerifyTheChangeProfilePicResponseMessageMatches(String string) {

		ChangeProfilePic_Output_pojo changeProfilePic_Output_pojo = response.as(ChangeProfilePic_Output_pojo.class);
		String message = changeProfilePic_Output_pojo.getMessage();
		Assert.assertEquals("verify firstname", string, message);
	}

}
