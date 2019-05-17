package com.sgic.hrm.trainer.service;

import java.util.List;

import com.sgic.hrm.commons.entity.trainer.Availability;
public interface AvailabilityService {
	
	boolean addAvailability(Availability availability);

	List<Availability> getAllAvailability();

	boolean editAvailability(Availability availability, Integer id);

	boolean deleteAvailability(Integer id);

	Availability getById(Integer id);


}
