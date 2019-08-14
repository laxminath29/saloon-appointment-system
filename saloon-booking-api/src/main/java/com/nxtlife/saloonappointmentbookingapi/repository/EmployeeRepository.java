package com.nxtlife.saloonappointmentbookingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nxtlife.saloonappointmentbookingapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
