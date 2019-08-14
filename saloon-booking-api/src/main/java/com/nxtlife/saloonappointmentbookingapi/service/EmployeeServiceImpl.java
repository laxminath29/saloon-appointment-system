package com.nxtlife.saloonappointmentbookingapi.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nxtlife.saloonappointmentbookingapi.entity.Employee;
import com.nxtlife.saloonappointmentbookingapi.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		
		employeeRepository.findAll().forEach(employeeList::add);
		return employeeList;
	}

	public Employee getEmployee(Integer emp_id) throws IllegalArgumentException{
		
		return employeeRepository.findById(emp_id).orElse(null);
		
	}

	public boolean isEmployeeExist(Employee employee) {
		return  employeeRepository.existsById(employee.getEmp_id());
	}

	public Employee saveOrUpdateEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	public List<Employee> saveOrUpdateEmployees(List<Employee> employeeList){
		return employeeRepository.saveAll(employeeList);
	}
	
	public void deleteEmployeeById(Integer emp_id) throws IllegalArgumentException{
		employeeRepository.deleteById(emp_id);
		
	}

	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
		
	}

	
	
	

}
