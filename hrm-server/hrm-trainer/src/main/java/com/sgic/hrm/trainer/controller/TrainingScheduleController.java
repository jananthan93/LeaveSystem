package com.sgic.hrm.trainer.controller;
//done by daminiya
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

import com.sgic.hrm.commons.entity.trainer.TrainingSchedule;
import com.sgic.hrm.commons.trainer.dto.TrainingScheduleData;
import com.sgic.hrm.commons.trainer.dto.mapper.TrainingScheduleDataToTrainingSchedule;
import com.sgic.hrm.commons.trainer.entity.mapper.TrainingScheduleToTrainingScheduleData;
import com.sgic.hrm.trainer.service.TrainingScheduleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",maxAge=3600)
public class TrainingScheduleController {
	@Autowired
	private TrainingScheduleService trainingScheduleService;

	@PostMapping("/trainingSchedule")
	public HttpStatus trainingSchedule(@RequestBody TrainingScheduleData trainingScheduleData) {
		TrainingSchedule trainingSchedule= TrainingScheduleDataToTrainingSchedule
				.mapToTrainingSchedule(trainingScheduleData);
		if (trainingScheduleService.addTrainingSchedule(trainingSchedule)) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/trainingSchedule")
	public ResponseEntity<List<TrainingScheduleData>> getTrainingSchedule() {
		List<TrainingSchedule> trainingScheduleList = trainingScheduleService.getAllTrainingSchedule();
		return new ResponseEntity<>(
				TrainingScheduleToTrainingScheduleData.mapToTrainingScheduleDataList(trainingScheduleList),
				HttpStatus.OK);
	}
//get by id method
	@GetMapping("/trainingSchedule/{id}")
	public ResponseEntity<TrainingScheduleData> getOneTrainingSchedule(@PathVariable(name = "id") Integer id) {
		TrainingSchedule trainingSchedule = trainingScheduleService.getOneTrainingSchedule(id);
		return new ResponseEntity<>(
				TrainingScheduleToTrainingScheduleData.mapToTrainingScheduleData(trainingSchedule),
				HttpStatus.OK);
	}

	@PutMapping("/trainingSchedule/{id}")
	public HttpStatus updateTrainingSchedule(@PathVariable(name = "id") Integer id,
			@RequestBody TrainingScheduleData trainingScheduleData) {
		TrainingSchedule trainingSchedule = TrainingScheduleDataToTrainingSchedule
				.mapToTrainingSchedule(trainingScheduleData);
		if (trainingScheduleService.updateTrainingSchedule(id, trainingSchedule)) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping("/trainingSchedule/{id}")
	public HttpStatus deleteTrainingSchedule(@PathVariable(name = "id") Integer id) {
		if (trainingScheduleService.deleteTrainingSchedule(id)) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

}
