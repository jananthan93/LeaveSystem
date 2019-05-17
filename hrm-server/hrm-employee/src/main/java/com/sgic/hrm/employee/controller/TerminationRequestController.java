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

import com.sgic.hrm.commons.dto.TerminationRequestData;
import com.sgic.hrm.commons.dto.mapper.TerminationRequestDataToTerminationRequest;
import com.sgic.hrm.commons.entity.mapper.TerminationRequestToTerminationRequestData;
import com.sgic.hrm.employee.service.TerminationRequestService;

@CrossOrigin(origins = "http://localhost:4200",maxAge=3600)

@RestController
public class TerminationRequestController {
	@Autowired
	TerminationRequestService terminationRequestService;

	@GetMapping("/terminationRequest/status")
	public ResponseEntity<List<TerminationRequestData>> getByStatus() {
		return new ResponseEntity<>(TerminationRequestToTerminationRequestData
				.mapToTerminationRequestDataList(terminationRequestService.getPendingTerminationRequest()), HttpStatus.OK);
	}

	@GetMapping("/terminationRequest")
	public ResponseEntity<List<TerminationRequestData>> getAllTerminationRequest() {

		return new ResponseEntity<>(TerminationRequestToTerminationRequestData
				.mapToTerminationRequestDataList(terminationRequestService.getAllTerminationRequest()), HttpStatus.OK);
	}
	
	@PostMapping("/terminationRequest")
	public ResponseEntity<String> addTerminationRequest(@RequestBody TerminationRequestData terminationRequestData) {

		if (terminationRequestService.addTerminationRequest(TerminationRequestDataToTerminationRequest.mapToTerminationRequest(terminationRequestData))) {
			return new ResponseEntity<>("TerminationRequest Create Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("TerminationRequest Create Failed ", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/terminationRequest/{id}")
	public ResponseEntity<String> editTerminationRequest(@PathVariable(name = "id") Integer id,
			@RequestBody TerminationRequestData terminationRequestData) {
		if (terminationRequestService.editTerminationRequest(TerminationRequestDataToTerminationRequest.mapToTerminationRequest(terminationRequestData), id)) {
			return new ResponseEntity<>("TerminationRequest Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("TerminationRequest Update Failed ", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/terminationRequest/{id}")
	public ResponseEntity<String> deleteTerminationRequest(@PathVariable(name = "id") Integer id) {
		if (terminationRequestService.deleteTerminationRequest(id)) {
			return new ResponseEntity<>("TerminationRequest Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("TerminationRequest Delete Failed ", HttpStatus.BAD_REQUEST);

	}


}
