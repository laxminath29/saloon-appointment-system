package com.nxtlife.saloonappointmentbookingapi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="SERVICE_OFFERED")
public class ServiceOffered {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ser_id;
	
	
	@Column(nullable=false, unique=true)
	private String serviceName;
	
	@Column(nullable=false ,precision = 3, scale = 1)
	private Float duration;
	
	@Column(nullable=false , precision = 8, scale = 2)
	private Double price;
	
	@JsonIgnore
	@NotNull
	@ManyToMany(mappedBy = "serviceOffered", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Employee> employee = new HashSet<>();


	public Integer getSer_id() {
		return ser_id;
	}


	public void setSer_id(Integer ser_id) {
		this.ser_id = ser_id;
	}


	public String getService_name() {
		return serviceName;
	}


	public void setService_name(String service_name) {
		this.serviceName = service_name;
	}


	public Float getDuration() {
		return duration;
	}


	public void setDuration(Float duration) {
		this.duration = duration;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Set<Employee> getEmployee() {
		return employee;
	}


	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}


	public ServiceOffered() {
		
	}
	public ServiceOffered(Integer ser_id, String service_name, Float duration, Double price,
			@NotNull Set<Employee> employee) {
		super();
		this.ser_id = ser_id;
		this.serviceName = service_name;
		this.duration = duration;
		this.price = price;
		this.employee = employee;
	}
	
	



}
