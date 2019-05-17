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

import com.sgic.hrm.commons.dto.TerminationRecordData;
import com.sgic.hrm.commons.dto.mapper.TerminationRecordDataToTerminationRecord;
import com.sgic.hrm.commons.entity.mapper.TerminationRecordToTerminationRecordData;
import com.sgic.hrm.employee.service.TerminationRecordService;
@CrossOrigin(origins = "http://localhost:4200",maxAge=3600)
@RestController
public class TerminationRecordController {
	@Autowired
	TerminationRecordService terminationRecordService;

	@GetMapping("/terminationRecord/{id}")
	public ResponseEntity<TerminationRecordData> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(TerminationRecordToTerminationRecordData
				.mapToTerminationRecordData(terminationRecordService.getById(id)), HttpStatus.OK);
	}

	@GetMapping("/terminationRecord")

	public ResponseEntity<List<TerminationRecordData>> getAllTerminationRecord() {

		return new ResponseEntity<>(TerminationRecordToTerminationRecordData
				.mapToTerminationRecordList(terminationRecordService.getAllTerminationRecord()), HttpStatus.OK);
	}

	@PostMapping("/terminationRecord")
	public ResponseEntity<String> addTerminationRecord(@RequestBody TerminationRecordData terminationRecordData) {

		if (terminationRecordService.addTerminationRecord(
				TerminationRecordDataToTerminationRecord.mapToTerminationRecord(terminationRecordData))) {
			return new ResponseEntity<>("terminationRecord Create Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("terminationRecord Create Failed ", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/terminationRecord/{id}")
	public ResponseEntity<String> editTerminationRecord(@PathVariable(name = "id") Integer id,
			@RequestBody TerminationRecordData terminationRecordData) {
		if (terminationRecordService.editTerminationRecord(
				TerminationRecordDataToTerminationRecord.mapToTerminationRecord(terminationRecordData), id)) {
			return new ResponseEntity<>("terminationRecord Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("terminationRecord Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/terminationRecord/{id}")
	public ResponseEntity<String> deleteTerminationRecord(@PathVariable(name = "id") Integer id) {
		if (terminationRecordService.deleteTerminationRecord(id)) {
			return new ResponseEntity<>("terminationRecord Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("terminationRecord Delete Failed ", HttpStatus.BAD_REQUEST);

	}

}
