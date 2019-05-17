package com.sgic.hrm.par.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.entity.par.ScheduleParContent;
import com.sgic.hrm.commons.repository.par.ScheduleParContentRepository;
import com.sgic.hrm.par.service.ScheduleParContentService;



@Service
public class ScheduleParContentServiceImpl implements ScheduleParContentService{

	@Autowired
	ScheduleParContentRepository scheduleParContentRepo;
	
	@Override
	public void createScheduleParContent(ScheduleParContent scheduleParContent, Par par) {
		scheduleParContent.setParId(par);
		scheduleParContentRepo.save(scheduleParContent);
	}

	@Override
	public List<ScheduleParContent> findScheduleParContentByParId(Par parId) {
		// TODO Auto-generated method stub
		return scheduleParContentRepo.findByParId(parId);
	}

	@Override
	public void deleteScheduleParContent(String id) {
		// TODO Auto-generated method stub
		scheduleParContentRepo.deleteById(id);
	}
}
