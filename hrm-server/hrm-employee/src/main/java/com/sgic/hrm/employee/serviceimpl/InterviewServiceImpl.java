package com.sgic.hrm.employee.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Interview;
import com.sgic.hrm.commons.repository.InterviewRepository;
import com.sgic.hrm.employee.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewRepository interviewRepository;

	@Override
	public boolean addInterview(Interview interview) {
		interviewRepository.save(interview);
		return true;
	}

}
