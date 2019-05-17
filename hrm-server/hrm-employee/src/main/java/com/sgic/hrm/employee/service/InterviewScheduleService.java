package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.InterviewSchedule;



public interface InterviewScheduleService {
	
	boolean addInterviewSchedule(InterviewSchedule interviewSchedule);
	  
	   List<InterviewSchedule> getAllInterviewSchedule();
	   
	   boolean editInterviewSchedule(InterviewSchedule interviewSchedule, Integer id);
	   
	   boolean deleteInterviewSchedule(Integer id);
	   
	   InterviewSchedule getById(Integer id);


}
