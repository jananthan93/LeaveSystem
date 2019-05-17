package com.sgic.hrm.employee.serviceimpl;

import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Interviewers;
import com.sgic.hrm.commons.repository.InterviewersRepository;
import com.sgic.hrm.employee.service.InterviewersServices;

@Service
public class interviewersServicesImpl implements InterviewersServices {
	
	private InterviewersRepository interviewsRepisitory;

	@Override
	public boolean addInterviewers(Interviewers interviewers) {
		interviewsRepisitory.save(interviewers);
		return true;
	}

}
