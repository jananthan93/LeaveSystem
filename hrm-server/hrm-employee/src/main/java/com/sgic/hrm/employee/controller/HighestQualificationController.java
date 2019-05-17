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

import com.sgic.hrm.commons.dto.HighestQualificationData;
import com.sgic.hrm.commons.dto.mapper.HighestQualificationDataMapper;
import com.sgic.hrm.commons.entity.HighestQualification;
import com.sgic.hrm.employee.service.HighestQualificationService;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
public class HighestQualificationController {
	@Autowired
	private HighestQualificationService highestQualificationService;

	@PostMapping("/highestQualification")
	public HttpStatus createHighestQualification(@RequestBody HighestQualificationData highestQualificationData)  {
		boolean test = highestQualificationService.addHighestQualification(HighestQualificationDataMapper.highestQualificationDataMapper(highestQualificationData));
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/highestQualification")
	public ResponseEntity<List<HighestQualification>> getHighestQualification() {
		List<HighestQualification> highestQualification = highestQualificationService.getAllHighestQualification();
		ResponseEntity<List<HighestQualification>> response = new ResponseEntity<>(highestQualification, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/highestQualification/{id}")
	public HttpStatus editHighestQualification(@RequestBody HighestQualification highestQualification, @PathVariable("id") Integer id) {
		boolean test = highestQualificationService.editHighestQualification(highestQualification, id);
		if (test) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;

	}

	@DeleteMapping("/highestQualification/{id}")
	public HttpStatus deleteHighestQualification(@PathVariable("id") Integer id) {
		boolean test = highestQualificationService.deleteHighestQualification(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}
}
