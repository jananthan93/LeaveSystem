package com.sgic.hrm.trainer.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.trainer.dto.AvailabilityData;
import com.sgic.hrm.commons.trainer.dto.mapper.AvailabilityDataToAvailability;
import com.sgic.hrm.commons.trainer.entity.mapper.AvailabilityToAvailabilityData;
import com.sgic.hrm.trainer.service.AvailabilityService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/available")
@RestController
public class AvailabilityController {
	
	@Autowired
	AvailabilityService availabilityService;
	
	@GetMapping("/{id}")
	public ResponseEntity<AvailabilityData> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(
				AvailabilityToAvailabilityData.mapToAvailabilityData(availabilityService.getById(id)),
				HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List< AvailabilityData>> getAllAvailability() {

		return new ResponseEntity<>(AvailabilityToAvailabilityData
				.mapToAvailabilityDataList(availabilityService.getAllAvailability()), HttpStatus.OK);
	}

	@PostMapping
	public HttpStatus addAvailability(@RequestBody AvailabilityData availabilityData) {

		if (availabilityService
				.addAvailability(AvailabilityDataToAvailability.mapToAvailability(availabilityData))) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> editAvailability(@PathVariable(name = "id") Integer id,
			@RequestBody AvailabilityData availabilityData) {
		if (availabilityService.editAvailability(
				AvailabilityDataToAvailability.mapToAvailability(availabilityData), id)) {
			return new ResponseEntity<>("Availability Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Availability Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAvailability(@PathVariable(name = "id") Integer id) {
		if (availabilityService.deleteAvailability(id)) {
			return new ResponseEntity<>("Availability Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Availability Delete Failed ", HttpStatus.BAD_REQUEST);

	}

}
