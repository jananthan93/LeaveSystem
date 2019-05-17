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

import com.sgic.hrm.commons.dto.RejectedApplicantData;
import com.sgic.hrm.commons.dto.RejectedApplicantDataSave;
import com.sgic.hrm.commons.dto.mapper.RejectedApplicantDataMapper;
import com.sgic.hrm.commons.entity.RejectedApplicant;
import com.sgic.hrm.employee.service.RejectedApplicantService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
public class RejectedApplicantController {

	@Autowired
	private RejectedApplicantService rejectedApplicantService;

	@PostMapping("/rejectedApplicant")
	public HttpStatus createRejectedApplicant(@RequestBody RejectedApplicantDataSave rejectedApplicantDataSave) {
		boolean test = rejectedApplicantService
				.addRejectedApplicant(RejectedApplicantDataMapper.rejectedApplicantDataSaveMapper(rejectedApplicantDataSave));
		if (test) {
			return HttpStatus.CREATED;

		}

		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/rejectedApplicant")
	public ResponseEntity<List<RejectedApplicant>> getRejectedApplicant() {
		List<RejectedApplicant> rejectedApplicant = rejectedApplicantService.getAllRejectedApplicant();
		ResponseEntity<List<RejectedApplicant>> response = new ResponseEntity<>(rejectedApplicant, HttpStatus.OK);
		return response;
	}

//	@GetMapping("/rejectedApplicant/{id}")
//	public RejectedApplicant getOneById(@PathVariable("id") Integer rejectedApplicant_id) {
//		return rejectedApplicantService.getById(rejectedApplicant_id);
//	}

	@PutMapping("/rejectedApplicant/{id}")
	public ResponseEntity<String> updateRejectedApplicant(@PathVariable(name = "id") Integer id,
			@RequestBody RejectedApplicantData rejectedApplicantData) {
		RejectedApplicant rejectedApplicant = RejectedApplicantDataMapper
				.rejectedApplicantDataMapper(rejectedApplicantData);
		if (rejectedApplicantService.editRejectedApplicant(rejectedApplicant, id)) {
			return new ResponseEntity<>("updated", HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/rejectedApplicant/{id}")
	public HttpStatus deleteRejectedApplicant(@PathVariable("id") Integer id) {
		boolean test = rejectedApplicantService.deleteRejectedApplicant(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}

}
