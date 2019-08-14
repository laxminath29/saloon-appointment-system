package com.nxtlife.saloonappointmentbookingapi.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="HOLIDAY")
public class Holiday {
	@Id
	@GeneratedValue()
	private Integer holiday_id;
	
	
	//@Temporal(value=TemporalType.DATE)
	Date onleave;
	
	@Transient
	@ManyToMany(mappedBy = "holidays", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> employees = new HashSet<>();


	public Integer getHoliday_id() {
		return holiday_id;
	}


	public void setHoliday_id(Integer holiday_id) {
		this.holiday_id = holiday_id;
	}


	public Date getOnleave() {
		return onleave;
	}


	public void setOnleave(Date onleave) {
		this.onleave = onleave;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

 
	public Holiday() {
		
	}
	
	public Holiday(Integer holiday_id, Date onleave, Set<Employee> employees) {
		super();
		this.holiday_id = holiday_id;
		this.onleave = onleave;
		this.employees = employees;
	}
	
	

}
