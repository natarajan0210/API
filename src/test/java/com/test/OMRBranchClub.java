package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.ChangeProfilePic_Output_pojo;
import com.pojo.DeleteAddress_Input_pojo;
import com.pojo.GETAddress_Output_pojo;
import com.pojo.Login_Output_pojo;
import com.pojo.UpdateAddress_Input_pojo;
import com.pojo.UpdateAddress_Output_pojo;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class OMRBranchClub extends BaseClass {
	
	String logtoken;
	String valueOf;

	@Test(priority = 1)
	private void createuser() throws FileNotFoundException, IOException {

		addHeader("accept", "application/json");
		basicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));
		Response response = requestType("POST", Endpoints.POSTMANAUTHLOGIN);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		Login_Output_pojo login_Output_pojo = response.as(Login_Output_pojo.class);
		logtoken = login_Output_pojo.getData().getLogtoken();

		String first_name = login_Output_pojo.getData().getFirst_name();
		System.out.println(first_name);

		Assert.assertEquals(statusCode, 200, "Verify status code");
		Assert.assertEquals(first_name, "Natarajan", "Verify first name");
	}

	@Test(priority = 2)
	private void addAddress() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		addHeaders(h);

		AddAddress_Input_pojo addAddress_Input_pojo = new AddAddress_Input_pojo("Natarajan", "N", "6374803139", "White",
				"12", "1243", "621", "621001", "Thoraipakkam", "Chennai");
		addBody(addAddress_Input_pojo);

		Response response = requestType("POST", Endpoints.ADDUSERADDRESS);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		AddAddress_Output_pojo addAddress_Output_pojo = response.as(AddAddress_Output_pojo.class);

		String message = addAddress_Output_pojo.getMessage();
		int address_id = addAddress_Output_pojo.getAddress_id();
		valueOf = String.valueOf(address_id);

		Assert.assertEquals(statusCode, 200, "Verify status code");
		Assert.assertEquals(message, "Address added successfully", "Verify the address");
	}

	@Test(priority = 3)
	private void updadateAddress() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		addHeaders(h);

		UpdateAddress_Input_pojo updateAddress_Input_pojo = new UpdateAddress_Input_pojo(valueOf, "Natarajan", "N",
				"6374803139", "White", "12", "1243", "621", "621000", "Thoraipakkam", "Chennai");
		addBody(updateAddress_Input_pojo);

		Response response = requestType("PUT", Endpoints.UPDATEUSERADDRESS);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");

		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);

		String message = updateAddress_Output_pojo.getMessage();
		Assert.assertEquals(message, "Address updated successfully", "Verify the updated address");

	}

	@Test(priority = 4)
	private void deleteAddress() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		addHeaders(h);

		DeleteAddress_Input_pojo deleteAddress_Input_pojo = new DeleteAddress_Input_pojo(valueOf);
		addBody(deleteAddress_Input_pojo);

		Response response = requestType("DELETE", Endpoints.DELETEUSERADDRESS);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		Assert.assertEquals(statusCode, 200, "Verify status code");

		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);

		String message = updateAddress_Output_pojo.getMessage();
		Assert.assertEquals(message, "Address deleted successfully", "Verify address deleted");

	}

	@Test(priority = 5)
	private void getAddress() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		addHeaders(h);

		Response response = requestType("GET", Endpoints.GETUSERADDRESS);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		Assert.assertEquals(statusCode, 200, "Verify status code");

		GETAddress_Output_pojo getAddress_Output_pojo = response.as(GETAddress_Output_pojo.class);

		String message = getAddress_Output_pojo.getMessage();
		Assert.assertEquals(message, "OK", "Verify OK");

	}

	@Test(priority = 6)
	private void changeProfile() {

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");
		h.add(h1);
		h.add(h2);
		h.add(h3);
		addHeaders(h);

		formData();

		Response response = requestType("POST", Endpoints.CHANGEPROFILEPIC);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		ChangeProfilePic_Output_pojo changeProfilePic_Output_pojo = response.as(ChangeProfilePic_Output_pojo.class);
		
		String message = changeProfilePic_Output_pojo.getMessage();
		Assert.assertEquals(message, "Profile updated Successfully", "Verify Profile updated Successfully");
		
	}

}
