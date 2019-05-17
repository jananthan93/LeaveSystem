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

import com.sgic.hrm.commons.dto.mapper.trainee.TraineeRefereeDtoMapper;
import com.sgic.hrm.commons.dto.trainee.TraineeRefereeDto;
import com.sgic.hrm.commons.dto.trainee.TraineeRefereeSaveDto;
import com.sgic.hrm.commons.entity.mapper.trainee.TraineeRefereeMapper;
import com.sgic.hrm.trainee.service.TraineeRefereeService;
import com.sgic.hrm.trainee.service.TraineeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TraineeRefereeController {
	@Autowired
	private TraineeRefereeService traineeRefereeService;
	@Autowired
	private TraineeService traineeService;

	@PostMapping("/referee")
	public HttpStatus addReferee(@Valid @RequestBody TraineeRefereeSaveDto refereesSaveDto) {
		if (traineeRefereeService.addReferee(TraineeRefereeDtoMapper.map(refereesSaveDto),
				traineeService.findTraineeById(refereesSaveDto.getTrainee()))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/referee")
	public ResponseEntity<List<TraineeRefereeDto>> getReferee() {
		return new ResponseEntity<>(
				TraineeRefereeMapper.mapRefereeListToRefereeDtoList(traineeRefereeService.getAllReferee()),
				HttpStatus.OK);
	}

	@PutMapping("/referee/{id}")
	public HttpStatus editReferee(@RequestBody TraineeRefereeSaveDto refereesSaveDto, @PathVariable("id") Integer id) {
		boolean test = traineeRefereeService.editReferee(TraineeRefereeDtoMapper.map(refereesSaveDto), id,
				traineeService.findTraineeById(refereesSaveDto.getTrainee()));
		if (test) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;

	}

	@DeleteMapping("/referee/{id}")
	public HttpStatus deleteReferee(@PathVariable("id") Integer Id) {
		if (traineeRefereeService.deleteReferee(Id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/referee/{uid}")
	public ResponseEntity<List<TraineeRefereeDto>> findAcademicQualificationByUserId(@PathVariable("uid") Integer id) {
		return new ResponseEntity<>(
				TraineeRefereeMapper.mapRefereeListToRefereeDtoList(traineeRefereeService.getRefereeByTraineeId(id)),
				HttpStatus.OK);
	}
}
