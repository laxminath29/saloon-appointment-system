package com.nxtlife.saloonappointmentbookingapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.nxtlife.saloonappointmentbookingapi.dto.EmployeeView;
import com.nxtlife.saloonappointmentbookingapi.dto.HttpResponseDto;
import com.nxtlife.saloonappointmentbookingapi.entity.Employee;
import com.nxtlife.saloonappointmentbookingapi.entity.ServiceOffered;
import com.nxtlife.saloonappointmentbookingapi.service.EmployeeServiceImpl;



@RestController
@RequestMapping("/employees")
public class EmployeeController {
	 public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl ;
	
	/* ----------------------------- Fetching all the Employees ---------------------------*/
	@RequestMapping(value="",method = RequestMethod.GET )
	
	public ResponseEntity<?> getAllEmployees(){
		logger.info("Fetching All the Employees ");
		
		List<Employee> employeeList = employeeServiceImpl.getAllEmployees();
		if(employeeList.isEmpty()) {
			return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("No Record exist for Employees Table",HttpStatus.NO_CONTENT),HttpStatus.OK);
		}
		
/*	
 * ----------------  Code to return EmployeeView DTO ----------------------------
 *   
 *   	List<EmployeeView> employeeViews = new ArrayList<>();
		for(Employee empl : employeeList) {
			List<String> serviceOffered = new ArrayList<>();
			
			for(ServiceOffered ser : empl.getServiceOffered()){
					serviceOffered.add(ser.getService_name());
			}
			
			EmployeeView empView = new EmployeeView(empl.getFirst_name(),empl.getLast_name(),empl.getGender(),empl.getEmail(),empl.getMobile_number(),serviceOffered);
            employeeViews.add(empView);
			
      	}	*/
		return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
	}
	
	/* -------------------------- Fetching a single employee ---------------------------------*/
	@RequestMapping(value="/{emp_id}",method = RequestMethod.GET )
	public ResponseEntity<?> getEmployee(@PathVariable Integer emp_id){
		logger.info("Fetching Employee with name {}", employeeServiceImpl.getEmployee(emp_id).getFirst_name()+" "+employeeServiceImpl.getEmployee(emp_id).getLast_name());
		
		
		if(emp_id == null || !(emp_id instanceof Integer)) {
			 logger.error(" Cannot fetch Employee details as Employee ID can't be null or format not supported. ");
			 return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("NOT ACCEPTABLE. Pls give valid Employee ID in the request. ",HttpStatus.EXPECTATION_FAILED),HttpStatus.EXPECTATION_FAILED);
		}
		Employee emp = employeeServiceImpl.getEmployee(emp_id);
		if(emp==null) {
			 logger.error("Employee with id {} not found.", emp_id);
		   return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("Employee with id : "+ emp_id +" not found ",HttpStatus.NO_CONTENT) ,HttpStatus.OK);
		}
		
		
		List<String> serviceOffered = new ArrayList<>();
	
		for(ServiceOffered ser : emp.getServiceOffered()){
				serviceOffered.add(ser.getService_name());
		}
		
		EmployeeView empView = new EmployeeView(emp.getFirst_name(),emp.getLast_name(),emp.getGender(),emp.getEmail(),emp.getMobile_number(),serviceOffered);
		/*
		 * this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.email = email;
		this.mobile_number = mobile_number;
		this.serviceOffered=serviceOffered;*/
		return new ResponseEntity<EmployeeView>(empView,HttpStatus.OK);
	}
	
	
	/* -------------------------Creating an Employee-------------------------------  */
	@RequestMapping(method=RequestMethod.POST , value="/")
	
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee,UriComponentsBuilder ucBuilder) {
        logger.info("Creating Employee with name : {}", employee.getFirst_name() +" "+ employee.getLast_name());
        
        
 
        if (employeeServiceImpl.isEmployeeExist(employee)) {
            logger.error("Unable to create. A Employee with name {} already exist", employee.getFirst_name()+" "+employee.getLast_name());
            return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("Unable to create. A Employee with name "+ employee.getFirst_name()+" "+employee.getLast_name()+" already exist",HttpStatus.CONFLICT),HttpStatus.CONFLICT);
        }
        
        Employee currentEmployee= employeeServiceImpl.saveOrUpdateEmployee(employee);
        if(currentEmployee == null) {
        	logger.error("Unable to save deatils into database for the newly entered Employee with name : ", employee.getFirst_name()+" "+employee.getLast_name());
            return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("Unable to save deatils into database for the newly entered Employee with name :  "+ employee.getFirst_name()+" "+employee.getLast_name()+".",HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        
        	
        }
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employees/{emp_id}").buildAndExpand(employee.getEmp_id()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
	
	/* -------------------------Creating multiple Employees-------------------------------  */
	@RequestMapping(method=RequestMethod.POST , value="/bulk")
	
	public ResponseEntity<?> createEmployees(@RequestBody List<Employee> employees,UriComponentsBuilder ucBuilder) {
       for(Employee employee : employees)
		logger.info("Creating Employees with name : {}", employee.getFirst_name() +" "+ employee.getLast_name());
        
        
      for(Employee employee : employees) {
        if (employeeServiceImpl.isEmployeeExist(employee)) {
            logger.error("Unable to create. A Employee with name {} already exist", employee.getFirst_name()+" "+employee.getLast_name());
            return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("Unable to create. A Employee with name "+ employee.getFirst_name()+" "+employee.getLast_name()+" already exist.. Aborting further Inserts",HttpStatus.CONFLICT),HttpStatus.CONFLICT);
        }
      }
        List<Employee> currentEmployees= employeeServiceImpl.saveOrUpdateEmployees(employees);
        if(currentEmployees == null) {
        	logger.error("Unable to save deatils into database for the newly entered Employees");
            return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("Unable to save deatils into database for the newly entered Employees",HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        
        	
        }
 
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/employees/{emp_id}").buildAndExpand(employee.getEmp_id()).toUri());
        return new ResponseEntity<>(currentEmployees, HttpStatus.CREATED);
    }
	
	/*----------------------- Update an Employee ---------------------------  */
	
	@RequestMapping(value = "/{emp_id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@PathVariable Integer emp_id, @RequestBody Employee employee) {
        logger.info("Updating Employee with name : {}", employee.getFirst_name() +" "+ employee.getLast_name());
        if(emp_id == null) {
			 logger.error(" Cannot update Employee details as Employee ID can't be null. ");
			 return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("NOT ACCEPTABLE. Pls give valid Employee ID in the request. ",HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
		}
        
        Employee currentEmployee =  employeeServiceImpl.getEmployee(emp_id);
        if (currentEmployee == null) {
            logger.error("Unable to update. Employee with specified ID having name: {} not found.", employee.getFirst_name() +" "+ employee.getLast_name());
            return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("Unable to update. Employee with name : "+employee.getFirst_name() +" "+ employee.getLast_name() +"not found.",HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
        }
        
        /*"emp_id": 3,
        "first_name": "Third",
        "last_name": "Pandey",
        "email": "third@gmail.com",
        "gender": "Female",
        "mobile_number": "9999834567",
        "coming_time": "11:00:00",
        "leaving_time": "23:00:00",
        "schedule": [],
        "serviceOffered": [],
        "appointment": [],
        "holidays": 
        */
        
        currentEmployee.setAppointment(employee.getAppointment());
        currentEmployee.setComing_time(employee.getComing_time());
        currentEmployee.setLeaving_time(employee.getLeaving_time());
        currentEmployee.setEmail(employee.getEmail());
        currentEmployee.setFirst_name(employee.getFirst_name());
        currentEmployee.setLast_name(employee.getLast_name());
        currentEmployee.setMobile_number(employee.getMobile_number());
        currentEmployee.setSchedule(employee.getSchedule());
        currentEmployee.setGender(employee.getGender());
        currentEmployee.setHolidays(employee.getHolidays());
        currentEmployee.setServiceOffered(employee.getServiceOffered());
        
        Employee tempCurrentEmployee=employeeServiceImpl.saveOrUpdateEmployee(currentEmployee);
        if(tempCurrentEmployee == null) {
        	logger.error("Unable to Update changes to database for A Employee with name : ", currentEmployee.getFirst_name()+" "+currentEmployee.getLast_name());
            return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("Unable to  Update changes to database for A Employee with name :  "+ currentEmployee.getFirst_name()+" "+currentEmployee.getLast_name()+".",HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        
        	
        }
        
    	List<String> serviceOffered = new ArrayList<>();
    	
        for(ServiceOffered ser : tempCurrentEmployee.getServiceOffered()){
			serviceOffered.add(ser.getService_name());
	        }
        
        EmployeeView empView = new EmployeeView(tempCurrentEmployee.getFirst_name(),tempCurrentEmployee.getLast_name(),tempCurrentEmployee.getGender(),tempCurrentEmployee.getEmail(),tempCurrentEmployee.getMobile_number(),serviceOffered);
        
        return new ResponseEntity<EmployeeView>(empView, HttpStatus.OK);
	}
	
	// ------------------- Delete a Employee-----------------------------------------
	 
    @RequestMapping(value = "/{emp_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Integer emp_id) {
        logger.info("Fetching & Deleting User with id {}", emp_id);
        
        if(emp_id == null) {
			 logger.error(" Cannot delete Employee details as Employee ID can't be null. ");
			 return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("NOT ACCEPTABLE. Pls give valid Employee ID in the request. ",HttpStatus.EXPECTATION_FAILED),HttpStatus.EXPECTATION_FAILED);
		}
 
        Employee employee = employeeServiceImpl.getEmployee(emp_id);
        if (employee == null) {
            logger.error("Unable to delete. Employee with id {} not found.", emp_id);
            return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("Unable to delete. Employee with id : "+emp_id+ " not found.",HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
        }
        employeeServiceImpl.deleteEmployeeById(emp_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
 // ------------------- Delete All Employees-----------------------------
    
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteAllEmployees() {
        logger.info("Deleting All Employees");
 
        employeeServiceImpl.deleteAllEmployees();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
