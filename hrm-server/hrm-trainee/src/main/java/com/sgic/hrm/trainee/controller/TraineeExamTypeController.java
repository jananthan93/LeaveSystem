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

import com.sgic.hrm.commons.entity.trainee.TraineeExamType;
import com.sgic.hrm.trainee.service.TraineeExamTypeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TraineeExamTypeController {
	@Autowired
	private TraineeExamTypeService examTypeService;

	@PostMapping("/examtype")
	public HttpStatus createExamType(@Valid @RequestBody TraineeExamType examtype) {
		if (examTypeService.addExamType(examtype)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/examtype")
	public ResponseEntity<List<TraineeExamType>> getExamType() {
		return new ResponseEntity<>(examTypeService.getAllExamType(), HttpStatus.OK);

	}

	@PutMapping("/examtype/{id}")
	public HttpStatus editExamType(@PathVariable Integer id, @RequestBody TraineeExamType examtype) {
		if (examTypeService.editExamType(examtype, id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping("/examtype/{id}")
	public HttpStatus deleteExamType(@PathVariable Integer id, @RequestBody TraineeExamType examtype) {
		if (examTypeService.deleteExamType(id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
