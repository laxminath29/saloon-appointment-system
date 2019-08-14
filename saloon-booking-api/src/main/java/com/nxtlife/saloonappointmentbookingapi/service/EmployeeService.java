package com.nxtlife.saloonappointmentbookingapi.service;

import java.util.List;

import com.nxtlife.saloonappointmentbookingapi.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee getEmployee(Integer emp_id);
	public boolean isEmployeeExist(Employee employee);
	public Employee saveOrUpdateEmployee(Employee employee) ;
	public void deleteEmployeeById(Integer emp_id);
	public void deleteAllEmployees();
	public List<Employee> saveOrUpdateEmployees(List<Employee> employeeList);
	

}
