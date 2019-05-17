package com.sgic.hrm.par.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.entity.par.ScheduleParAppraisor;
import com.sgic.hrm.commons.repository.par.ScheduleParAppraisorRepository;
import com.sgic.hrm.par.service.ScheduleParAppraisorService;
@Service
public class ScheduleParAppraisorServiceImpl implements ScheduleParAppraisorService{

	@Autowired
	ScheduleParAppraisorRepository scheduleParAppraisorRepo;
	
	@Override
	public void createScheduleParAppraisor(ScheduleParAppraisor scheduleParAppraisor, Par par) {
		scheduleParAppraisor.setParId(par);
		scheduleParAppraisorRepo.save(scheduleParAppraisor);
	}

	@Override
	public List<ScheduleParAppraisor> findScheduleParAppraisorByParId(Par parId) {
		// TODO Auto-generated method stub
		return scheduleParAppraisorRepo.findByParId(parId);
	}

	@Override
	public void deleteScheduleParAppraisorById(String id) {
		// TODO Auto-generated method stub
		scheduleParAppraisorRepo.deleteById(id);
	}
	
}
