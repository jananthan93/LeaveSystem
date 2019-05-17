//package com.sgic.hrm.employee.controller;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sgic.hrm.commons.dto.InterviewDto;
//import com.sgic.hrm.commons.entity.Interview;
//import com.sgic.hrm.commons.entity.Interviewers;
//import com.sgic.hrm.employee.service.ApplicantsInterviewService;
//import com.sgic.hrm.employee.service.InterviewService;
//import com.sgic.hrm.employee.service.InterviewersServices;
//import com.sgic.hrm.profile.service.JobService;
//
//@RestController
//public class InterviewController {
//
//	@Autowired
//	private InterviewService interviewService;
//	
//	@Autowired
//	private InterviewersServices interviewersServices;
//	
//	@Autowired
//	private ApplicantsInterviewService applicantsInterviewService;
//	
//	@Autowired
//	private JobService jobService;
//	
//	@Transactional
//	@PostMapping("/interview")
//	public HttpStatus addInterview(@RequestBody InterviewDto interviewDto ) {
//		
//		Interview interview=new Interview();
//		//interview.setId(interviewDto.getId());
//		interview.setInterviewPanelNo(interviewDto.getInterviewPanelNo());
//		interview.setStartTime(interviewDto.getStartTime());
//		interview.setEndTime(interviewDto.getEndTime());
//		
//		
//		
//		
//		
//		
//		Interviewers interviewers=new Interviewers();
//		
//		
//		
//		
//		return null;
//		
//	}
//	
//	
//
//}
