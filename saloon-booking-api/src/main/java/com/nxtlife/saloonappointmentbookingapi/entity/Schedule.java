package com.nxtlife.saloonappointmentbookingapi.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SCHEDULE" , 
uniqueConstraints=
@UniqueConstraint(columnNames={"FK_EMP_ID","start_time", "end_time"}))
public class Schedule {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer sch_id;

@ManyToOne
@JoinColumn(name ="FK_EMP_ID")
@NotNull
private Employee employee;

@Column(nullable=false)
@Temporal(TemporalType.TIMESTAMP)
private Calendar start_time;



@Column(nullable=false)
@Temporal(TemporalType.TIMESTAMP)
private Calendar end_time;


public Integer getSch_id() {
	return sch_id;
}

public void setSch_id(Integer sch_id) {
	this.sch_id = sch_id;
}

public Employee getSch_emp_id() {
	return employee;
}

public void setSch_emp_id(Employee sch_emp_id) {
	this.employee = sch_emp_id;
}

public Calendar getStart_time() {
	return start_time;
}

public void setStart_time(Calendar start_time) {
	this.start_time = start_time;
}

public Calendar getEnd_time() {
	return end_time;
}

public void setEnd_time(Calendar end_time) {
	this.end_time = end_time;
}



public void setSch_id(int sch_id) {
	this.sch_id = sch_id;
}
public Schedule() {
	
}

public Schedule(Employee sch_emp_id, Calendar start_time, Calendar end_time,Integer sch_id) {
	super();
	this.employee = sch_emp_id;
	this.start_time = start_time;
	this.end_time = end_time;
	this.sch_id=sch_id;
}




}
