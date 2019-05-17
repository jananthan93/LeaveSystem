package com.sgic.hrm.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.AppointmentTypeData;
import com.sgic.hrm.commons.dto.LeaveAllocationData;
import com.sgic.hrm.commons.dto.UserData;
import com.sgic.hrm.commons.dto.mapper.AppointmentTypeDataToAppointmentType;
import com.sgic.hrm.commons.dto.mapper.UserDataToUser;
import com.sgic.hrm.commons.entity.mapper.LeaveAllocationToLeaveAllocationData;
import com.sgic.hrm.lms.service.LeaveAllocationService;
import com.sgic.hrm.lms.service.LeaveTypeService;
import com.sgic.hrm.lms.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/leaveallocation")
public class LeaveAllocationController {

	@Autowired
	LeaveAllocationService leaveAllocationService;
	@Autowired
	LoginService loginService;
	@Autowired
	LeaveTypeService leaveTypeService;

	@PostMapping
	public HttpStatus allocateLeave(UserData userData, AppointmentTypeData appointmentTypeData) {
		if (leaveAllocationService.allocateLeave(UserDataToUser.mapToUser(userData),
				AppointmentTypeDataToAppointmentType.mapToAppointmentType(appointmentTypeData),
				leaveTypeService.viewAllLeaveType())) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/annual/{username}")
	public ResponseEntity<LeaveAllocationData> getByUserAndType(@PathVariable(name = "username") String username) {

		return new ResponseEntity<>(LeaveAllocationToLeaveAllocationData.mapToLeaveAllocationData(
				leaveAllocationService.getByUserAndType(loginService.getUser(username))), HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<List<LeaveAllocationData>> viewLeaveAllocationByUser(
			@PathVariable(name = "username") String username) {

		return new ResponseEntity<>(
				LeaveAllocationToLeaveAllocationData.mapToLeaveAllocationDataList(
						leaveAllocationService.viewLeaveAllocationByUser(loginService.getUser(username))),
				HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteLeaveAllocation(@PathVariable(name = "id") Integer id) {
		if (leaveAllocationService.deleteLeaveAllocation(id)) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

}
