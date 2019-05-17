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
import com.sgic.hrm.commons.dto.mapper.trainee.TraineeWorkExperienceDtoMapper;
import com.sgic.hrm.commons.dto.trainee.TraineeWorkExperienceDto;
import com.sgic.hrm.commons.dto.trainee.TraineeWorkExperienceSaveDto;
import com.sgic.hrm.commons.entity.mapper.trainee.TraineeWorkExperienceMapper;
import com.sgic.hrm.trainee.service.TraineeService;
import com.sgic.hrm.trainee.service.TraineeWorkExperienceService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TraineeWorkExperienceController {
	@Autowired
	private TraineeWorkExperienceService traineeWorkExperienceService;

	@Autowired
	private TraineeService traineeService;

	@PostMapping("/workexperience")
	public HttpStatus addWorkExperience(@Valid @RequestBody TraineeWorkExperienceSaveDto traineeWorkExperienceSaveDto) {
		if (traineeWorkExperienceService.addWorkExperience(
				TraineeWorkExperienceDtoMapper.map(traineeWorkExperienceSaveDto),
				traineeService.findTraineeById(traineeWorkExperienceSaveDto.getTrainee()))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/workexperience/{id}")
	public HttpStatus modifyworkexperience(@PathVariable Integer id,
			@RequestBody TraineeWorkExperienceSaveDto traineeWorkExperienceSaveDto) {
		if (traineeWorkExperienceService.editWorkExperience(
				TraineeWorkExperienceDtoMapper.map(traineeWorkExperienceSaveDto),
				traineeService.findTraineeById(traineeWorkExperienceSaveDto.getTrainee()), id)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/workexperience")
	public ResponseEntity<List<TraineeWorkExperienceDto>> getWorkExperience() {
		return new ResponseEntity<>(TraineeWorkExperienceMapper.mapWorkExperienceListToWorkExperienceDtoList(
				traineeWorkExperienceService.getAllWorkExperience()), HttpStatus.OK);
	}

	@GetMapping("/workexperience/{uid}")
	public ResponseEntity<List<TraineeWorkExperienceDto>> getworkExperiencesByUserId(@PathVariable("uid") Integer id) {
		return new ResponseEntity<>(TraineeWorkExperienceMapper.mapWorkExperienceListToWorkExperienceDtoList(
				traineeWorkExperienceService.getWorkExperienceByTraineeId(id)), HttpStatus.OK);
	}

	@DeleteMapping("/workexperience/{id}")
	public HttpStatus deleteWorkexperience(@PathVariable Integer id) {
		if (traineeWorkExperienceService.deleteWorkExperience(id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

}
