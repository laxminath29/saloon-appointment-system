package com.nxtlife.saloonappointmentbookingapi.dto;

import java.util.List;

public class EmployeeView {
	
	private String first_name;
	private String last_name;
	private String gender;
	private String email;
	private String mobile_number;
	private List<String> serviceOffered;
	
	
	public List<String> getServiceOffered() {
		return serviceOffered;
	}
	public void setServiceOffered(List<String> serviceOffered) {
		this.serviceOffered = serviceOffered;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	public EmployeeView () {
		
	}
	
	
	public EmployeeView(String first_name, String last_name, String gender, String email, String mobile_number , List<String> serviceOffered) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.email = email;
		this.mobile_number = mobile_number;
		this.serviceOffered=serviceOffered;
	}
	
	

}
