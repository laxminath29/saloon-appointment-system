package com.nxtlife.saloonappointmentbookingapi.entity;

import java.util.Calendar;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.nxtlife.saloonappointmentbookingapi.utility.AppointmentStatus;

@Entity
@Table(name="APPOINTMENT")
public class Appointment {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="APPOINTMENT_ID")
	private Integer app_id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_ON",nullable=false)
	private Date created_on;
	
	/*
	 * @OneToOne(mappedBy="appointment") private ServiceAppointment
	 * serviceAppointment;
	 */
	
	@ManyToOne
	@JoinColumn(name= "FK_APP_EMP_ID",nullable=false)
	private Employee employee;

	@ManyToOne
	@JoinColumn(name= "FK_APP_CLIENT_ID",nullable=false)
	private Client client;
	
	@Enumerated(EnumType.STRING)
	@Column(name="APPOINTMENT_STATUS")
	private AppointmentStatus appointmentStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar start_time;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar end_expected_time;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Calendar end_time;
	
	@Column(precision = 8, scale = 2 , nullable=true)
	private Double discount;
	
	@Column(precision = 8, scale = 2, nullable=true)
	private Double final_price;
	
	@Column(nullable=true)
	private String cancellation_reason;
	
	@OneToOne
	@JoinColumn(name="FK_SER_ID")
	private ServiceOffered serviceOffered;

	public Integer getApp_id() {
		return app_id;
	}

	public void setApp_id(Integer app_id) {
		this.app_id = app_id;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public Calendar getStart_time() {
		return start_time;
	}

	public void setStart_time(Calendar start_time) {
		this.start_time = start_time;
	}

	public Calendar getEnd_expected_time() {
		return end_expected_time;
	}

	public void setEnd_expected_time(Calendar end_expected_time) {
		this.end_expected_time = end_expected_time;
	}

	public Calendar getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Calendar end_time) {
		this.end_time = end_time;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getFinal_price() {
		return final_price;
	}

	public void setFinal_price(Double final_price) {
		this.final_price = final_price;
	}

	public String getCancellation_reason() {
		return cancellation_reason;
	}

	public void setCancellation_reason(String cancellation_reason) {
		this.cancellation_reason = cancellation_reason;
	}

	public ServiceOffered getServiceOffered() {
		return serviceOffered;
	}

	public void setServiceOffered(ServiceOffered serviceOffered) {
		this.serviceOffered = serviceOffered;
	}

	
	public Appointment() {
		
	}
	public Appointment(Integer app_id, Date created_on, Employee employee, Client client,
			AppointmentStatus appointmentStatus, Calendar start_time, Calendar end_expected_time, Calendar end_time,
			Double discount, Double final_price, String cancellation_reason, ServiceOffered serviceOffered) {
		super();
		this.app_id = app_id;
		this.created_on = created_on;
		this.employee = employee;
		this.client = client;
		this.appointmentStatus = appointmentStatus;
		this.start_time = start_time;
		this.end_expected_time = end_expected_time;
		this.end_time = end_time;
		this.discount = discount;
		this.final_price = final_price;
		this.cancellation_reason = cancellation_reason;
		this.serviceOffered = serviceOffered;
	}
	
	
	
	
	

}
