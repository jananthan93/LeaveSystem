
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
import com.sgic.hrm.commons.dto.mapper.trainee.TraineeAcademicQualificationDtoMapper;
import com.sgic.hrm.commons.dto.trainee.TraineeAcademicQualificationDto;
import com.sgic.hrm.commons.dto.trainee.TraineeAcademicQualificationSaveDto;
import com.sgic.hrm.commons.entity.mapper.trainee.TraineeAcademicQualificationMapper;
import com.sgic.hrm.trainee.service.TraineeAcademicQualificationService;
import com.sgic.hrm.trainee.service.TraineeExamTypeService;
import com.sgic.hrm.trainee.service.TraineeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TraineeAcademicQualificationController {
	@Autowired
	private TraineeAcademicQualificationService traineeAcademicQualificationService;
	@Autowired
	private TraineeService traineeService;
	@Autowired
	private TraineeExamTypeService traineeExamTypeService;

	@PostMapping("/academicQualification")
	public HttpStatus addAcademicQualification(
			@Valid @RequestBody TraineeAcademicQualificationSaveDto traineeAcademicQualificationSaveDto) {
		if (traineeAcademicQualificationService.addAcademicQualification(
				TraineeAcademicQualificationDtoMapper
						.mapAcademicQualificationSaveDtoToAcademicQualification(traineeAcademicQualificationSaveDto),
				traineeExamTypeService.findByExamTypeId(traineeAcademicQualificationSaveDto.getExamType()),
				traineeService.findTraineeById(traineeAcademicQualificationSaveDto.getTrainee()))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/academicQualification")
	public ResponseEntity<List<TraineeAcademicQualificationDto>> getAcademicQualification() {
		return new ResponseEntity<>(
				TraineeAcademicQualificationMapper.mapAcademicQualificationListToAcademicQualificationDtoList(
						traineeAcademicQualificationService.getAllAcademicQualification()),
				HttpStatus.OK);

	}

	@GetMapping("/academicQualification/{uid}")
	public ResponseEntity<List<TraineeAcademicQualificationDto>> findAcademicQualificationByUserId(
			@PathVariable("uid") Integer id) {
		return new ResponseEntity<>(
				TraineeAcademicQualificationMapper.mapAcademicQualificationListToAcademicQualificationDtoList(
						traineeAcademicQualificationService.getAcademicQualificationByTraineeId(id)),
				HttpStatus.OK);
	}

	@PutMapping("/academicQualification/{id}")
	public HttpStatus editAcademicQualification(@PathVariable Integer id,
			@Valid @RequestBody TraineeAcademicQualificationSaveDto traineeAcademicQualificationSaveDto) {
		if (traineeAcademicQualificationService.editAcademicQualification(
				TraineeAcademicQualificationDtoMapper
						.mapAcademicQualificationSaveDtoToAcademicQualification(traineeAcademicQualificationSaveDto),
				traineeExamTypeService.findByExamTypeId(traineeAcademicQualificationSaveDto.getExamType()),
				traineeService.findTraineeById(traineeAcademicQualificationSaveDto.getTrainee()), id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping("/academicQualification/{id}")
	public HttpStatus deleteAcademicQualification(@PathVariable Integer id) {
		if (traineeAcademicQualificationService.deleteAcademicQualification(id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
