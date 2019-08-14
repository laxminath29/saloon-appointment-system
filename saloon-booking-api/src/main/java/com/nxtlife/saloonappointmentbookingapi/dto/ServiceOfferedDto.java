package com.nxtlife.saloonappointmentbookingapi.dto;

public class ServiceOfferedDto {
	
	private String serviceName;
	private Double duration;
	private Double price;
	public String getService_name() {
		return serviceName;
	}
	public void setService_name(String service_name) {
		this.serviceName = service_name;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public ServiceOfferedDto(String service_name, Double duration, Double price) {
		super();
		this.serviceName = service_name;
		this.duration = duration;
		this.price = price;
	}
	
	

}
