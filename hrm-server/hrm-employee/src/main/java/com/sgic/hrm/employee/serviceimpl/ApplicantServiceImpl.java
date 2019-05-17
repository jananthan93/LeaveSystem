package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Applicant;
import com.sgic.hrm.commons.repository.ApplicantRepository;
import com.sgic.hrm.employee.service.ApplicantService;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Override
	public boolean addApplicant(Applicant applicant) {
		applicantRepository.save(applicant);
		return true;
	}

	@Override
	public List<Applicant> getAllApplicant() {
		return applicantRepository.findAll();
	}

	@Override
	public boolean editApplicant(Applicant applicant, Integer id) {
		boolean success = false;
		if (applicantRepository.getOne(id) != null) {
			applicant.setId(id);
			applicantRepository.save(applicant);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteApplicant(Integer id) {
		Applicant applicant = applicantRepository.getOne(id);
		if (applicant.getId() == (id)) {
			applicantRepository.deleteById(id);
			return true;
		}
		return false;
	}

//	@Override
//	public Applicant getById(Integer id) {
//		return applicantRepository.getOne(id);
//	}



}
