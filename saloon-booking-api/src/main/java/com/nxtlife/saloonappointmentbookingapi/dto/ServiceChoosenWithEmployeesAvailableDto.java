package com.nxtlife.saloonappointmentbookingapi.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ServiceChoosenWithEmployeesAvailableDto {
	private String service_name;
	private float duration;
	private Double price;
	private Calendar start_time;
	private Calendar expected_end_time;
	private List<EmployeeView> employees = new ArrayList<>();
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Calendar getStart_time() {
		return start_time;
	}
	public void setStart_time(Calendar start_time) {
		this.start_time = start_time;
	}
	public Calendar getExpected_end_time() {
		return expected_end_time;
	}
	public void setExpected_end_time(Calendar expected_end_time) {
		this.expected_end_time = expected_end_time;
	}
	public List<EmployeeView> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeView> employees) {
		this.employees = employees;
	}
	public ServiceChoosenWithEmployeesAvailableDto(String service_name, float duration, Double price,
			Calendar start_time, Calendar expected_end_time, List<EmployeeView> employees) {
		super();
		this.service_name = service_name;
		this.duration = duration;
		this.price = price;
		this.start_time = start_time;
		this.expected_end_time = expected_end_time;
		this.employees = employees;
	}
	
	

}
