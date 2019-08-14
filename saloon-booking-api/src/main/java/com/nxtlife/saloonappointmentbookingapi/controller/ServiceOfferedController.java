package com.nxtlife.saloonappointmentbookingapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nxtlife.saloonappointmentbookingapi.dto.HttpResponseDto;

import com.nxtlife.saloonappointmentbookingapi.entity.ServiceOffered;
import com.nxtlife.saloonappointmentbookingapi.service.ServiceOfferedServiceImpl;

@RestController
@RequestMapping("services")
public class ServiceOfferedController {
	 public static final Logger logger = LoggerFactory.getLogger(ServiceOfferedController.class);
	 
	 @Autowired
		private ServiceOfferedServiceImpl serviceOfferedServiceImpl ;
	 
	 /* ----------------------------- Fetching all the Services ---------------------------*/
		@RequestMapping(value="",method = RequestMethod.GET )
		
		public ResponseEntity<?> getAllServices(){
			logger.info("Fetching All the Services available ");
			List<ServiceOffered> serviceOfferedList = serviceOfferedServiceImpl.getAllServices();
			if(serviceOfferedList.isEmpty()) {
				return new ResponseEntity<HttpResponseDto>(new HttpResponseDto("No Record exist for ServiceOffered Table",HttpStatus.NO_CONTENT),HttpStatus.OK);
			}
			return new ResponseEntity<List<ServiceOffered>>(serviceOfferedList,HttpStatus.OK);
		}
		

	

}
