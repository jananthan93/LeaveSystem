package com.sgic.hrm.employee.serviceimpl;

import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.ApplicantsInterview;
import com.sgic.hrm.commons.repository.ApplicantsInterviewRepository;
import com.sgic.hrm.employee.service.ApplicantsInterviewService;

@Service
public class ApplicantsInterviewServiceImpl implements ApplicantsInterviewService {

	private ApplicantsInterviewRepository applicantsInterviewRepository;

	@Override
	public boolean addApplicantsInterviewService(ApplicantsInterview applicantsInterview) {
		applicantsInterviewRepository.save(applicantsInterview);
		return true;
	}

}
