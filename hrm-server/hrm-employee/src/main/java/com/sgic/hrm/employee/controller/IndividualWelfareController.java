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

import com.sgic.hrm.commons.dto.IndividualWelfareData;
import com.sgic.hrm.commons.dto.mapper.IndividualWelfareDataToIndividualWelfare;
import com.sgic.hrm.commons.entity.mapper.IndividualWelfareToIndividualWelfareData;
import com.sgic.hrm.employee.service.IndividualWelfareService;


@CrossOrigin(origins = "http://localhost:4200",maxAge=3600)
@RestController

public class IndividualWelfareController {
@Autowired
private IndividualWelfareService individualWelfareService;


//@GetMapping("/individualWelfare/{id}")
//public ResponseEntity<IndividualWelfareData> getById(@PathVariable(name ="id") Integer id) {
//	return new ResponseEntity<>(
//			IndividualWelfareToIndividualWelfareData.maptoIndividualWelfareData(individualWelfareService.getById(id)),
//			HttpStatus.OK);
//}

//@GetMapping("/individualWelfare")
//public ResponseEntity<List<IndividualWelfareData>> getAllIndividualWelfare() {
//
//	return new ResponseEntity<>(IndividualWelfareToIndividualWelfareData
//			.maptoIndividualWelfareList(individualWelfareService.getAllIndividualWelfare()), HttpStatus.OK);
//}

//@PostMapping("/individualWelfare")
//public ResponseEntity<String> createIndividualWelfare(@RequestBody IndividualWelfareData individualWelfareData) {
//
//	if (individualWelfareService
//			.createIndividualWelfare(IndividualWelfareDataToIndividualWelfare.maptoIndividualWelfare(individualWelfareData))) {
//		return new ResponseEntity<>("IndividualWelfare Create Succesfully ", HttpStatus.OK);
//	}
//	return new ResponseEntity<>("IndividualWelfare Create Failed ", HttpStatus.BAD_REQUEST);
//}

//@PutMapping("/individualWelfare/{id}")
//public ResponseEntity<String> updateIndividualWelfare(@PathVariable(name = "id") Integer id,
//		@RequestBody IndividualWelfareData individualWelfareData) {
//	if (individualWelfareService.updateIndividualWelfare(
//			IndividualWelfareDataToIndividualWelfare.maptoIndividualWelfare(individualWelfareData), id)) {
//		return new ResponseEntity<>("IndividualWelfare Update Succesfully ", HttpStatus.OK);
//	}
//	return new ResponseEntity<>("IndividualWelfare Update Failed ", HttpStatus.BAD_REQUEST);
//}

@DeleteMapping("/individualWelfare/{id}")
public ResponseEntity<String> deleteIndividualWelfare(@PathVariable(name = "id") Integer id) {
	if (individualWelfareService.deleteIndividualWelfare(id)) {
		return new ResponseEntity<>("IndividualWelfare Delete Succesfully ", HttpStatus.OK);
	}
	return new ResponseEntity<>("IndividualWelfare Delete Failed ", HttpStatus.BAD_REQUEST);

}

}

	








