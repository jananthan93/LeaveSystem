package com.sgic.hrm.trainee.controller;

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

import com.sgic.hrm.commons.dto.mapper.trainee.TraineeDtoMapper;
import com.sgic.hrm.commons.dto.trainee.TraineeDto;
import com.sgic.hrm.commons.dto.trainee.TraineeSaveDto;
import com.sgic.hrm.commons.entity.mapper.trainee.TraineeMapper;
import com.sgic.hrm.trainee.service.TraineeDepartmentService;
import com.sgic.hrm.trainee.service.TraineeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TraineeController {
	@Autowired
	private TraineeService traineeService;
	@Autowired
	private TraineeDepartmentService traineeDepartmentService;

	@PostMapping("/trainee")
	public HttpStatus Addtrainee(@RequestBody TraineeSaveDto traineeSaveDto) {
		if (traineeService.addTrainee(TraineeDtoMapper.mapTraineeSaveDtoToTrainee(traineeSaveDto),
				traineeDepartmentService.findByDepartmentId(traineeSaveDto.getTraineeDepartment()))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/trainee")
	public ResponseEntity<List<TraineeDto>> getTrainee() {
		return new ResponseEntity<>(TraineeMapper.mapTraineeListToTraineeDtoList(traineeService.getTrainee()),
				HttpStatus.OK);
	}

	@PutMapping("/trainee/{id}")
	public HttpStatus editTrainee(@RequestBody TraineeSaveDto traineeSaveDto, @PathVariable("id") Integer id) {
		boolean test = traineeService.editTrainee(TraineeDtoMapper.mapTraineeSaveDtoToTrainee(traineeSaveDto),
				traineeDepartmentService.findByDepartmentId(traineeSaveDto.getTraineeDepartment()), id);
		if (test) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping("/trainee/{id}")
	public HttpStatus deleteTrainee(@PathVariable("id") Integer id) {
		if (traineeService.deleteTrainee(id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/trainee/{employment}")
	public List<TraineeDto> getTraineeByEmployment(@PathVariable String employment) {
		return TraineeMapper.mapTraineeListToTraineeDtoList(traineeService.findTraineeByEmployment(employment));
	}

	@GetMapping("/trainee/search/{name}")
	public List<TraineeDto> getTraineeByName(@PathVariable String name) {
		return TraineeMapper.mapTraineeListToTraineeDtoList(traineeService.findTraineebyfullName(name));
	}
}
