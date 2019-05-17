package com.sgic.hrm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.InterviewSchduleDataSave;
import com.sgic.hrm.commons.dto.InterviewScheduleData;
import com.sgic.hrm.commons.dto.mapper.InterviewScheduleDataMapper;
import com.sgic.hrm.commons.entity.InterviewSchedule;
import com.sgic.hrm.employee.service.InterviewScheduleService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
public class InterviewScheduleController {

	@Autowired
	private InterviewScheduleService interviewScheduleService;

//	@PostMapping("/interviewSchedule")
//	public HttpStatus createInterviewSchedule( @RequestBody InterviewScheduleData interviewScheduleData) {
//		boolean test = interviewScheduleService.addInterviewSchedule(InterviewScheduleDataMapper.interviewScheduleDataMapper(interviewScheduleData));
//		if (test) {
//			return HttpStatus.CREATED;
//
//		}
//
//		return HttpStatus.BAD_REQUEST;
//	}

	@PostMapping("/interviewSchedule")
	public HttpStatus createInterviewSchedule(@RequestBody InterviewSchduleDataSave interviewScheduleDataSave) {
		boolean test = interviewScheduleService.addInterviewSchedule(
				InterviewScheduleDataMapper.interviewScheduleDataSaveMapper(interviewScheduleDataSave));
		if (test) {
			return HttpStatus.CREATED;

		}

		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/interviewSchedule")
	public ResponseEntity<List<InterviewSchedule>> getInterviewSchedule() {
		List<InterviewSchedule> interviewSchedule = interviewScheduleService.getAllInterviewSchedule();
		ResponseEntity<List<InterviewSchedule>> response = new ResponseEntity<>(interviewSchedule, HttpStatus.OK);
		return response;
	}

//	@GetMapping("/interviewSchedule/{id}")
//	public InterviewSchedule getOneById(@PathVariable("id") Integer interviewSchedule_id) {
//		return interviewScheduleService.getById(interviewSchedule_id);
//	}

	@PutMapping("/interviewSchedule/{id}")
	public ResponseEntity<String> updateInterviewSchedule(@PathVariable(name = "id") Integer id,
			@RequestBody InterviewScheduleData interviewScheduleData) {
		InterviewSchedule interviewSchedule = InterviewScheduleDataMapper
				.interviewScheduleDataMapper(interviewScheduleData);
		if (interviewScheduleService.editInterviewSchedule(interviewSchedule, id)) {
			return new ResponseEntity<>("updated", HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/interviewSchedule/{id}")
	public HttpStatus deleteInterviewSchedule(@PathVariable("id") Integer id) {
		boolean test = interviewScheduleService.deleteInterviewSchedule(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}

}
