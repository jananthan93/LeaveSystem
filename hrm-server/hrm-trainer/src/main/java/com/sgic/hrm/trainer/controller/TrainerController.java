package com.sgic.hrm.trainer.controller;

//done by_Sujaany
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

import com.sgic.hrm.commons.trainer.dto.TrainerDto;
import com.sgic.hrm.commons.trainer.dto.mapper.TrainerDtoMapper;
import com.sgic.hrm.commons.trainer.entity.mapper.TrainerMapper;
import com.sgic.hrm.trainer.service.TrainerService;

@RestController
@CrossOrigin(origins = "*")
public class TrainerController {
	@Autowired
	TrainerService trainerService;

	@GetMapping("/trainer/{id}")
	public ResponseEntity<TrainerDto> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(TrainerMapper.mapToTrainerDTO(trainerService.getById(id)), HttpStatus.OK);
	}

	@GetMapping("/trainer")
	public ResponseEntity<List<TrainerDto>> getAllTerminationType() {

		return new ResponseEntity<>(TrainerMapper.mapToTrainerDTOList(trainerService.getAllTrainer()), HttpStatus.OK);
	}

	@PostMapping("/trainer")
	public ResponseEntity<String> createGeneralInformation(@RequestBody TrainerDto trainerDto) {

		if (trainerService.createTrainer(TrainerDtoMapper.mapToTrainer(trainerDto))) {
			return new ResponseEntity<>("Trainer Create Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Trainer Create Failed ", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/trainer/{id}")
	public ResponseEntity<String> updateGeneralInformation(@PathVariable(name = "id") Integer id,
			@RequestBody TrainerDto trainerDto) {
		if (trainerService.updateTrainer(TrainerDtoMapper.mapToTrainer(trainerDto), id)) {
			return new ResponseEntity<>("Trainer Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Trainer Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/trainer/{id}")
	public ResponseEntity<String> deleteGeneralInformation(@PathVariable(name = "id") Integer id) {
		if (trainerService.deleteTrainer(id)) {
			return new ResponseEntity<>("Trainer Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Trainer Delete Failed ", HttpStatus.BAD_REQUEST);
	}
}
