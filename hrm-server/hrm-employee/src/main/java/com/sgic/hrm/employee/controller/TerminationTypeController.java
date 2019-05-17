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

import com.sgic.hrm.commons.dto.TerminationTypeData;
import com.sgic.hrm.commons.dto.mapper.TerminationTypeDataToTerminationType;
import com.sgic.hrm.commons.entity.mapper.TerminationTypeToTerminationTypeData;
import com.sgic.hrm.employee.service.TerminationTypeService;
@CrossOrigin(origins = "*")
@RestController
public class TerminationTypeController {
	@Autowired
	TerminationTypeService terminationTypeService;

	@GetMapping("/terminationType/{id}")
	public ResponseEntity<TerminationTypeData> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(
				TerminationTypeToTerminationTypeData.mapToTerminationTypeData(terminationTypeService.getById(id)),
				HttpStatus.OK);
	}

	@GetMapping("/terminationType")
	public ResponseEntity<List<TerminationTypeData>> getAllTerminationType() {

		return new ResponseEntity<>(TerminationTypeToTerminationTypeData
				.mapToTerminationTypeDataList(terminationTypeService.getAllTerminationType()), HttpStatus.OK);
	}

	@PostMapping("/terminationType")
	public ResponseEntity<String> addTerminationType(@RequestBody TerminationTypeData terminationTypeData) {

		if (terminationTypeService
				.addTerminationType(TerminationTypeDataToTerminationType.mapToTerminationType(terminationTypeData))) {
			return new ResponseEntity<>("TerminationType Create Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("TerminationType Create Failed ", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/terminationType/{id}")
	public ResponseEntity<String> editTerminationType(@PathVariable(name = "id") Integer id,
			@RequestBody TerminationTypeData terminationTypeData) {
		if (terminationTypeService.editTerminationType(
				TerminationTypeDataToTerminationType.mapToTerminationType(terminationTypeData), id)) {
			return new ResponseEntity<>("TerminationType Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("TerminationType Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/terminationType/{id}")
	public ResponseEntity<String> deleteTerminationType(@PathVariable(name = "id") Integer id) {
		if (terminationTypeService.deleteTerminationType(id)) {
			return new ResponseEntity<>("TerminationType Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("TerminationType Delete Failed ", HttpStatus.BAD_REQUEST);

	}

}
