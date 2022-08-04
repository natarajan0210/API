package com.pojo;

public class AddAddress_Input_pojo {

	private String first_name;
	 private String last_name;
	 private String mobile;
	 private String apartment;
	 private String state;
	 private String city;
	 private String country;
	 private String zipcode;
	 private String address;
	 private String address_type;
	
	
	public AddAddress_Input_pojo(String first_name, String last_name, String mobile, String apartment, String state,
			String city, String country, String zipcode, String address, String address_type) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.apartment = apartment;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.address = address;
		this.address_type = address_type;
	}


	public String getFirst_name() {
		return first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public String getMobile() {
		return mobile;
	}


	public String getApartment() {
		return apartment;
	}


	public String getState() {
		return state;
	}


	public String getCity() {
		return city;
	}


	public String getCountry() {
		return country;
	}


	public String getZipcode() {
		return zipcode;
	}


	public String getAddress() {
		return address;
	}


	public String getAddress_type() {
		return address_type;
	}
	
	

}
