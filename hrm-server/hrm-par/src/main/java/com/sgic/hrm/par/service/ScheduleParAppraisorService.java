package com.sgic.hrm.par.service;

import java.util.List;

import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.entity.par.ScheduleParAppraisor;

public interface ScheduleParAppraisorService {

	public void createScheduleParAppraisor(ScheduleParAppraisor scheduleParAppraisor,Par par);
	
	public List<ScheduleParAppraisor>findScheduleParAppraisorByParId(Par parId);

	public void deleteScheduleParAppraisorById(String id);
}
