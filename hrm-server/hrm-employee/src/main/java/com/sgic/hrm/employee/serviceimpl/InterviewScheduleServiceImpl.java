package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.InterviewSchedule;
import com.sgic.hrm.commons.repository.InterviewScheduleRepository;
import com.sgic.hrm.employee.service.InterviewScheduleService;
@Service
public class InterviewScheduleServiceImpl implements InterviewScheduleService {
	
	@Autowired
	private InterviewScheduleRepository interviewScheduleRepository;
	
	@Override
	public boolean addInterviewSchedule(InterviewSchedule interviewSchedule) {
		interviewScheduleRepository.save(interviewSchedule);
		return true;
	}

	@Override
	public List<InterviewSchedule> getAllInterviewSchedule() {
		return interviewScheduleRepository.findAll();
	}

	@Override
	public boolean editInterviewSchedule(InterviewSchedule interviewSchedule, Integer id) {
		boolean success = false;
		if (interviewScheduleRepository.getOne(id) != null) {
			interviewSchedule.setId(id);
			interviewScheduleRepository.save(interviewSchedule);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteInterviewSchedule(Integer id) {
		InterviewSchedule interviewSchedule = interviewScheduleRepository.getOne(id);
		if (interviewSchedule.getId() == (id)) {
			interviewScheduleRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public InterviewSchedule getById(Integer id) {
		return interviewScheduleRepository.getOne(id);
	}


}
