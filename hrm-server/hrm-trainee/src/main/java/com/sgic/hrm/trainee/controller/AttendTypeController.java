package com.sgic.hrm.trainee.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.sgic.hrm.commons.entity.trainee.AttendStatus;
import com.sgic.hrm.commons.entity.trainee.AttendType;
import com.sgic.hrm.trainee.service.AttendTypeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AttendTypeController {
	@Autowired
	private AttendTypeService attendTypeService;

	@PostMapping("/attendence/type")
	public HttpStatus addAttendType(@Valid @RequestBody AttendType attendType) {
		if (attendTypeService.addAttendanceType(attendType)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/attendence/type")
	public ResponseEntity<List<AttendType>> getAttendType() {
		return new ResponseEntity<>(attendTypeService.getAttendanceType(), HttpStatus.OK);
	}

	@PutMapping("/attendence/type/{id}")
	public HttpStatus editAttendType(@RequestBody AttendType attendType, @PathVariable Integer id) {
		if (attendTypeService.editAttendType(attendType, id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping("/attendence/type/{id}")
	public HttpStatus deleteAttendType(@PathVariable Integer id) {
		if (attendTypeService.deleteAttendType(id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
