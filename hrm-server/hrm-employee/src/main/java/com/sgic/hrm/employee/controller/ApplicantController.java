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

import com.sgic.hrm.commons.dto.ApplicantDataSave;
import com.sgic.hrm.commons.dto.mapper.ApplicantDataMapper;
import com.sgic.hrm.commons.entity.Applicant;
import com.sgic.hrm.employee.service.ApplicantService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
public class ApplicantController {

	@Autowired
	private ApplicantService applicantService;

	@PostMapping("/applicant")
	public HttpStatus postRequestPromotion(@RequestBody ApplicantDataSave applicantDataSave) {

		boolean test = applicantService.addApplicant(ApplicantDataMapper.applicantDataSaveMapper(applicantDataSave));

		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/applicant/{id}")
	public ResponseEntity<String> updateApplicant(@PathVariable(name = "id") Integer id,
			@RequestBody ApplicantDataSave applicantDataSave) {
		Applicant applicant = ApplicantDataMapper.applicantDataSaveMapper(applicantDataSave);
		if (applicantService.editApplicant(applicant, id)) {
			return new ResponseEntity<>("updated", HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/applicant")
	public ResponseEntity<List<Applicant>> getApplicant() {
		List<Applicant> applicant = applicantService.getAllApplicant();
		ResponseEntity<List<Applicant>> response = new ResponseEntity<>(applicant, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/applicant/{id}")
	public HttpStatus deleteApplicant(@PathVariable("id") Integer id) {
		boolean test = applicantService.deleteApplicant(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}

}
