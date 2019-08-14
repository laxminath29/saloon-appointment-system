package com.nxtlife.saloonappointmentbookingapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nxtlife.saloonappointmentbookingapi.entity.ServiceOffered;
import com.nxtlife.saloonappointmentbookingapi.repository.ServiceOfferedRepository;

@Service
public class ServiceOfferedServiceImpl implements ServiceOfferedService {
	
	@Autowired
	private ServiceOfferedRepository serviceOfferedRepository;

	public List<ServiceOffered> getAllServices() {
		List<ServiceOffered> serviceOfferedList = new ArrayList<>();
		serviceOfferedRepository.findAll().forEach(serviceOfferedList::add);
		return serviceOfferedList;
	}
	
	public ServiceOffered getServiceByID(Integer serviceId) {
		return serviceOfferedRepository.findById(serviceId).orElse(null);
		//return serviceOfferedRepository.findByService_name(service_name);
	}
	
	public ServiceOffered getServiceByName(String service_name) {
		return serviceOfferedRepository.findByServiceName(service_name);
	}
	
	public ServiceOffered saveOrUpdateService(ServiceOffered serviceOffered) {
		return serviceOfferedRepository.save(serviceOffered);
	}

}
