package com.sgic.hrm.trainee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.mapper.trainee.AttendanceDetailsDtoMapper;
import com.sgic.hrm.commons.dto.trainee.AttendanceDetailsDto;
import com.sgic.hrm.commons.entity.trainee.AttendanceDetails;
import com.sgic.hrm.trainee.service.AttendStatusService;
import com.sgic.hrm.trainee.service.AttendTypeService;
import com.sgic.hrm.trainee.service.AttendanceDetailsService;
import com.sgic.hrm.trainee.service.TraineeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AttendanceDetailsController {
	@Autowired
	private AttendanceDetailsService attendanceDetailsService;
	@Autowired
	private TraineeService traineeService;
	@Autowired
	private AttendTypeService attendTypeService;
	@Autowired
	private AttendStatusService attendStatusService;

	@PostMapping("/attedenceDetails")
	public HttpStatus addAttendanceDetails(@Valid @RequestBody AttendanceDetailsDto attendanceDetailsDto) {
		if (attendanceDetailsService.addAttendanceDetails(AttendanceDetailsDtoMapper.map(attendanceDetailsDto),
				traineeService.findTraineeById(attendanceDetailsDto.getTrainee()),
				attendTypeService.getAttendTypeId(attendanceDetailsDto.getAttendType()),
				attendStatusService.getAttendStatusId(attendanceDetailsDto.getAttendantStatus()))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/attedenceDetails")
	public ResponseEntity<List<AttendanceDetails>> getAttendanceDetails() {
		return new ResponseEntity<>(attendanceDetailsService.getAttendanceDetails(), HttpStatus.OK);
	}
	
	@GetMapping("/attedenceDetails/{id}")
	public ResponseEntity<List<AttendanceDetails>> getAttendanceDetailsByTrainee(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(attendanceDetailsService.getAttendanceDetailsByTrainee(id), HttpStatus.OK);
	}
	
}
