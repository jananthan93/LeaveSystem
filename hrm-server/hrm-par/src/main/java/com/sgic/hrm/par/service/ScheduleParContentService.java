package com.sgic.hrm.par.service;

import java.util.List;

import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.entity.par.ScheduleParContent;

public interface ScheduleParContentService {

	public void createScheduleParContent(ScheduleParContent scheduleParContent,Par par);
	public List<ScheduleParContent>findScheduleParContentByParId(Par parId);
	public void deleteScheduleParContent(String id);
}
