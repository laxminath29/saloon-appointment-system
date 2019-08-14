package com.nxtlife.saloonappointmentbookingapi.entity;

import java.sql.Time;

//import java.sql.Date;


import java.util.Date;
//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.nxtlife.saloonappointmentbookingapi.entity.Schedule;
import com.nxtlife.saloonappointmentbookingapi.entity.ServiceOffered;

@Entity
@Table(name="EMPLOYEE", 
uniqueConstraints=
@UniqueConstraint(columnNames={"first_name", "mobile_number"})
)

public class Employee {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int emp_id;
@NotNull
private String first_name;
private String last_name;

@NotNull
@Email
@Column(unique=true)
private String email;

@NotNull
private String gender;

@NotNull
@Column(length=11, unique=true)
private String mobile_number ;

//@Temporal(TemporalType.TIME)
@Column( nullable=false)
private Time coming_time;

//@Temporal(TemporalType.TIME)
@Column( nullable=false)
private Time leaving_time;

@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
private Set< Schedule >schedule= new HashSet<Schedule>();

@NotNull
@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(
        name = "SERVICE_OFFERED_EMPLOYEE",
        joinColumns = {@JoinColumn(name = "ser_id")}
       , inverseJoinColumns = {@JoinColumn(name = "emp_id")}
)
private Set<ServiceOffered> serviceOffered= new HashSet<>();

@OneToMany(mappedBy="employee" , cascade= CascadeType.ALL)
private Set<Appointment> appointment = new HashSet<>();

	/*
	 * @OneToMany(mappedBy="employee", cascade = CascadeType.ALL) private
	 * List<ServiceAppointment> serviceAppointment = new ArrayList<>();
	 */

@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinTable(
        name = "HOLIDAY_EMPLOYEE",
        joinColumns = {@JoinColumn(name = "emp_id")}
       , inverseJoinColumns = {@JoinColumn(name = "holiday_id")}
)
private Set<Holiday> holidays = new HashSet<>();





	/*
	 * public List<ServiceAppointment> getServiceAppointment() { return
	 * serviceAppointment; }
	 * 
	 * public void setServiceAppointment(List<ServiceAppointment>
	 * serviceAppointment) { this.serviceAppointment = serviceAppointment; }
	 */




 

public Employee() {
	super();
}


public Employee(int emp_id, @NotNull String first_name, String last_name, @NotNull @Email String email,
			@NotNull String gender, @NotNull String mobile_number, Time coming_time, Time leaving_time,
			Set<Schedule> schedule, @NotNull Set<ServiceOffered> serviceOffered, Set<Appointment> appointment,
			Set<Holiday> holidays) {
		super();
		this.emp_id = emp_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.coming_time = coming_time;
		this.leaving_time = leaving_time;
		this.schedule = schedule;
		this.serviceOffered = serviceOffered;
		this.appointment = appointment;
		this.holidays = holidays;
	}


public int getEmp_id() {
	return emp_id;
}


public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
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


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public String getMobile_number() {
	return mobile_number;
}


public void setMobile_number(String mobile_number) {
	this.mobile_number = mobile_number;
}


public Time getComing_time() {
	return coming_time;
}


public void setComing_time(Time coming_time) {
	this.coming_time = coming_time;
}


public Time getLeaving_time() {
	return leaving_time;
}


public void setLeaving_time(Time leaving_time) {
	this.leaving_time = leaving_time;
}


public Set<Schedule> getSchedule() {
	return schedule;
}


public void setSchedule(Set<Schedule> schedule) {
	this.schedule = schedule;
}


public Set<ServiceOffered> getServiceOffered() {
	return serviceOffered;
}


public void setServiceOffered(Set<ServiceOffered> serviceOffered) {
	this.serviceOffered = serviceOffered;
}


public Set<Appointment> getAppointment() {
	return appointment;
}


public void setAppointment(Set<Appointment> appointment) {
	this.appointment = appointment;
}


public Set<Holiday> getHolidays() {
	return holidays;
}


public void setHolidays(Set<Holiday> holidays) {
	this.holidays = holidays;
}




}
