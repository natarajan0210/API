package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.DeleteAddress_Input_pojo;
import com.pojo.GETAddress_Output_pojo;
import com.pojo.UpdateAddress_Input_pojo;
import com.pojo.UpdateAddress_Output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class AddressStep extends BaseClass {

	String logtoken;
	static String valueOf;
	static Response response;
	
	
	@Given("User add headers and bearer authorizaton for accessing new address endpoints")
	public void userAddHeadersAndBearerAuthorizatonForAccessingNewAddressEndpoints() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		addHeaders(h);
	}

	@When("User add request body for add new address {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile, String apartment,
			String state, String city, String country, String zipcode, String address, String address_type) {
		
		AddAddress_Input_pojo addAddress_Input_pojo = new AddAddress_Input_pojo("Natarajan", "N", "6374803139", "White",
				"12", "1243", "621", "621001", "Thoraipakkam", "Chennai");
		addBody(addAddress_Input_pojo);
	}

	@When("User send {string} request for add new address")
	public void userSendRequestForAddNewAddress(String string) {
		
		response = requestType("POST", Endpoints.ADDUSERADDRESS);
	}

	@Then("User should verify the add new address response message matches {string}")
	public void userShouldVerifyTheAddNewAddressResponseMessageMatches(String message) {
		
		AddAddress_Output_pojo addAddress_Output_pojo = response.as(AddAddress_Output_pojo.class);

		String message1 = addAddress_Output_pojo.getMessage();
		System.out.println(message1);
		int address_id = addAddress_Output_pojo.getAddress_id();
		valueOf = String.valueOf(address_id);
		System.out.println(valueOf);
		
		Assert.assertEquals("verify firstname", message, message1);
	}

	@Given("User add headers and bearer authorizaton for accessing update address endpoints")
	public void userAddHeadersAndBearerAuthorizatonForAccessingUpdateAddressEndpoints() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		addHeaders(h);
	}

	@When("User add request body for update existing address {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userAddRequestBodyForUpdateExistingAddressAnd(String valueOf, String first_name, String last_name, String mobile, String apartment,
			String state, String city, String country, String zipcode, String address, String address_type) {

		UpdateAddress_Input_pojo updateAddress_Input_pojo = new UpdateAddress_Input_pojo(valueOf, "Naveen", "N",
				"6374803139", "White", "12", "1243", "621", "621000", "Thoraipakkam", "Chennai");
		addBody(updateAddress_Input_pojo);
	}

	@When("User send {string} request for update existing address")
	public void userSendRequestForUpdateExistingAddress(String string) {
		
		response = requestType("PUT", Endpoints.UPDATEUSERADDRESS);
	}

	@Then("User should verify the update existing address response message matches {string}")
	public void userShouldVerifyTheUpdateExistingAddressResponseMessageMatches(String message1) {

		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
		String message = updateAddress_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals("verify firstname", message1, message);
	}

	@Given("User add headers and bearer authorizaton for accessing delete address endpoints")
	public void userAddHeadersAndBearerAuthorizatonForAccessingDeleteAddressEndpoints() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		addHeaders(h);
	}

	@When("User add request body for delete existing address {string}")
	public void userAddRequestBodyForDeleteExistingAddress(String string) {

		DeleteAddress_Input_pojo deleteAddress_Input_pojo = new DeleteAddress_Input_pojo(valueOf);
		addBody(deleteAddress_Input_pojo);
		System.out.println(valueOf);

	}

	@When("User send {string} request for delete existing address")
	public void userSendRequestForDeleteExistingAddress(String string) {

		response = requestType("DELETE", Endpoints.DELETEUSERADDRESS);

	}

	@Then("User should verify the delete existing address response message matches {string}")
	public void userShouldVerifyTheDeleteExistingAddressResponseMessageMatches(String valueOf) {

		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
		String message = updateAddress_Output_pojo.getMessage();
		Assert.assertEquals("verify firstname", valueOf, message);
	}

	@Given("User add headers and bearer authorizaton for accessing get address endpoints")
	public void userAddHeadersAndBearerAuthorizatonForAccessingGetAddressEndpoints() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.logtoken);
		h.add(h1);
		h.add(h2);
		addHeaders(h);
	}

	@When("User send {string} request for get existing address")
	public void userSendRequestForGetExistingAddress(String string) {

		response = requestType("GET", Endpoints.GETUSERADDRESS);
	}

	@Then("User should verify the get existing address response message matches {string}")
	public void userShouldVerifyTheGetExistingAddressResponseMessageMatches(String message) {

		GETAddress_Output_pojo getAddress_Output_pojo = response.as(GETAddress_Output_pojo.class);
		String message1 = getAddress_Output_pojo.getMessage();
		Assert.assertEquals("verify firstname", message, message1);

	}

}
