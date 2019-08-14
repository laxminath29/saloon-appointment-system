package com.nxtlife.saloonappointmentbookingapi.dto;

import java.util.Calendar;

public class ServiceChoosenWithTimestamp{

	private String service_name;
	private float duration;
	private Double price;
	private Calendar start_time;
	private Calendar expected_end_time;
	
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
		setExpected_end_time();
	}
	public Calendar getExpected_end_time() {
		return expected_end_time;
	}
	private void setExpected_end_time() {
		
		int hour ;
		int minute;
		hour= (int) duration;
		minute = (((int)(duration*10))-hour)*6;
		
		expected_end_time.set(start_time.get(0), start_time.get(1), start_time.get(2), start_time.get(3), start_time.get(4));
		expected_end_time.add(start_time.get(3),hour );
		expected_end_time.add(start_time.get(4),minute);
		
	}
	public ServiceChoosenWithTimestamp(String service_name, float duration, Double price, Calendar start_time,
			Calendar expected_end_time) {
		super();
		this.service_name = service_name;
		this.duration = duration;
		this.price = price;
		this.start_time = start_time;
		this.expected_end_time = expected_end_time;
	}
	
	

	
	

}
