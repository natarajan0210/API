package com.base;

import java.io.File;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	RequestSpecification reqSpec;
	Response response;

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}
	
	public void addHeaders(List<Header> h) {
		Headers headers = new Headers(h);
		reqSpec = RestAssured.given().headers(headers);
	}

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+ "\\config.properties"));
		String value = (String) properties.get(key);
		return value;
	}

	public void basicAuth(String username, String password) {
		reqSpec.auth().preemptive().basic(username, password);
	}

	public void pathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public void queryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public void addBody(String payLoad) {
		reqSpec = reqSpec.body(payLoad);
	}
	
	public void addBody(Object payLoad) {
		reqSpec = reqSpec.body(payLoad);
	}
	
	public void formData() {
		reqSpec = reqSpec.multiPart("profile_picture", new File("C:\\Users\\Naveen\\Downloads\\aesthetic-berlin-money-hean3kq.jpg"));
	}

	public Response requestType(String reqType, String endpoint) {

		switch (reqType) {
		case "GET":
			response = reqSpec.log().all().get(endpoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endpoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endpoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endpoint);
			break;
		default:
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public ResponseBody getResponseBody(Response response) {
		ResponseBody body = response.getBody();
		return body;
	}

	public String ResBodyAsString(Response response) {
		String asString = getResponseBody(response).asString();
		return asString;
	}

	public String getResBodyAsPretty(Response response) {
		String asPrettyString = getResponseBody(response).asPrettyString();
		return asPrettyString;
	}
}

