package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.HighestQualification;
import com.sgic.hrm.commons.repository.HighestQualificationRepository;
import com.sgic.hrm.employee.service.HighestQualificationService;



@Service
public class HighestQualificationServiceImpl implements HighestQualificationService{
	@Autowired
	private HighestQualificationRepository highestQualificationRepository;

	@Override
	public boolean addHighestQualification(HighestQualification highestQualification) {
		highestQualificationRepository.save(highestQualification);
		return true;
	}

	@Override
	public List<HighestQualification> getAllHighestQualification() {
		return highestQualificationRepository.findAll();
	}

	@Override
	public boolean editHighestQualification(HighestQualification highestQualification,
			Integer id) {
		boolean success = false;
		if (highestQualificationRepository.getOne(id) != null) {
			highestQualification.setId(id);
			highestQualificationRepository.save(highestQualification);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteHighestQualification(Integer id) {
		HighestQualification highestQualification = highestQualificationRepository.getOne(id);
		if (highestQualification.getId() == (id)) {
			highestQualificationRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
