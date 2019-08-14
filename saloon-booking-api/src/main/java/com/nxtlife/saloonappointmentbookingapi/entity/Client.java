package com.nxtlife.saloonappointmentbookingapi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.nxtlife.saloonappointmentbookingapi.utility.Gender;

@Entity
@Table(name="CLIENT")
public class Client {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer client_Id;

@Column(nullable=false)
String client_name;

@Column(nullable=false)
String client_mobile;

@Email
@Column(nullable=true)
String client_email;

@Enumerated(EnumType.STRING)
Gender gender;

@OneToMany(mappedBy="client")
Set<Appointment> appointments = new HashSet<>();

public Integer getClient_Id() {
	return client_Id;
}

public void setClient_Id(Integer client_Id) {
	this.client_Id = client_Id;
}

public String getClient_name() {
	return client_name;
}

public void setClient_name(String client_name) {
	this.client_name = client_name;
}

public String getClient_mobile() {
	return client_mobile;
}

public void setClient_mobile(String client_mobile) {
	this.client_mobile = client_mobile;
}

public String getEmail() {
	return client_email;
}

public void setEmail(String email) {
	this.client_email = email;
}

public Gender getGender() {
	return gender;
}

public void setGender(Gender gender) {
	this.gender = gender;
}

public Set<Appointment> getAppointments() {
	return appointments;
}

public void setAppointments(Set<Appointment> appointments) {
	this.appointments = appointments;
}

public Client() {
	
}
public Client(Integer client_Id, String client_name, String client_mobile, @Email String client_email, Gender gender,
		Set<Appointment> appointments) {
	super();
	this.client_Id = client_Id;
	this.client_name = client_name;
	this.client_mobile = client_mobile;
	this.client_email = client_email;
	this.gender = gender;
	this.appointments = appointments;
}



	
}
