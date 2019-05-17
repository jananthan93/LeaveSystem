package com.sgic.hrm.trainer.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainer.Availability;
import com.sgic.hrm.commons.trainer.repository.AvailabilityRepository;
import com.sgic.hrm.trainer.service.AvailabilityService;


@Service
public class AvailabilityServiceImpl implements AvailabilityService{
	@Autowired
	private AvailabilityRepository availabilityRepository;

	@Override
	public boolean addAvailability(Availability availability) {
		availabilityRepository.save(availability);
		return true;
	}

	@Override
	public List<Availability> getAllAvailability() {
		return availabilityRepository.findAll();
	}

	@Override
	public boolean editAvailability(Availability availability, Integer id) {
		boolean success = false;
		if (availabilityRepository.getOne(availability.getId()) != null) {
			availabilityRepository.save(availability);
			success = true;
		}
		return success;
	}

	@Override
	public boolean deleteAvailability(Integer id) {
		Availability availability = availabilityRepository.getOne(id);
		if (availability.getId() == (id)) {
			availabilityRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Availability getById(Integer id) {
		return availabilityRepository.getOne(id);
	}

}
