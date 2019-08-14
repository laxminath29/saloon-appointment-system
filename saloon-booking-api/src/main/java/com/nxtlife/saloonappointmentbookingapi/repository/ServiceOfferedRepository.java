package com.nxtlife.saloonappointmentbookingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nxtlife.saloonappointmentbookingapi.entity.ServiceOffered;

public interface ServiceOfferedRepository extends JpaRepository<ServiceOffered, Integer> {
             ServiceOffered findByServiceName(String service_name);
}
