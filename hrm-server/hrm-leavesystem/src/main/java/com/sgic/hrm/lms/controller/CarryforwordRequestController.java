package com.sgic.hrm.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.CarryforwardObjectData;
import com.sgic.hrm.commons.dto.CarryforwardRequestData;
import com.sgic.hrm.commons.dto.RejectCarryforwardData;
import com.sgic.hrm.commons.dto.mapper.CarryforwardRequestDataToCarryforwardRequest;
import com.sgic.hrm.commons.entity.CarryforwardRequest;
import com.sgic.hrm.commons.entity.mapper.CarryforwardRequestToCarryforwardRequestData;
import com.sgic.hrm.commons.enums.Status;
import com.sgic.hrm.lms.service.CarryforwardRequestService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/carryforwardrequest")
public class CarryforwordRequestController {

	@Autowired
	CarryforwardRequestService carryforwardRequestService;

	@GetMapping
	public ResponseEntity<List<CarryforwardRequestData>> viewAllCarryforwardRequest() {
		return new ResponseEntity<>(CarryforwardRequestToCarryforwardRequestData.mapToCarryforwardRequestDataList(
				carryforwardRequestService.viewAllCarryforwardRequest()), HttpStatus.OK);
	}
	
//	@GetMapping("/pending")
//	public ResponseEntity<List<CarryforwardRequestData>> getCarryforwardRequestByStatus() {
//		return new ResponseEntity<>(CarryforwardRequestToCarryforwardRequestData.mapToCarryforwardRequestDataList(
//				carryforwardRequestService.getCarryforwardRequestByStatus(Status.PENDING)), HttpStatus.OK);
//	}
	
	//Jananthan
	@GetMapping("/pending/{userName}")
	public ResponseEntity<List<CarryforwardRequest>> getCarryforwardRequestByStatus(@PathVariable("userName") String userName) {
		return new ResponseEntity<>(carryforwardRequestService.getCarryforwardRequestByStatusAndUserName(userName), HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<CarryforwardRequestData> getByUsername(@PathVariable String username) {

		return new ResponseEntity<>(CarryforwardRequestToCarryforwardRequestData
				.mapToCarryforwardRequestData(carryforwardRequestService.getByUsername(username)), HttpStatus.OK);
	}

	@PostMapping
	public HttpStatus createCarryforwardRequest(@RequestBody CarryforwardObjectData carryforwardObjectData) {
		if (carryforwardRequestService.createCarryforwardRequest(carryforwardObjectData)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PostMapping("/accept/{username}")
	public HttpStatus acceptCarryforwardRequest(@PathVariable("username") String username,
			@RequestBody CarryforwardRequestData carryforwardRequestData) {
		if (carryforwardRequestService.acceptCarryforwardRequest(username,
				CarryforwardRequestDataToCarryforwardRequest.mapToCarryforwardRequest(carryforwardRequestData))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PostMapping("/reject/{username}")
	public HttpStatus rejectCarryforwardRequest(@PathVariable("username") String username,
			@RequestBody RejectCarryforwardData rejectCarryforwardData) {
		if (carryforwardRequestService
				.rejectCarryforwardRequest(username,
						CarryforwardRequestDataToCarryforwardRequest
								.mapToCarryforwardRequest(rejectCarryforwardData.getCarryforwardRequestData()),
						rejectCarryforwardData.getReason())) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
}
