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
import com.sgic.hrm.commons.trainer.dto.UserTrainerData;
import com.sgic.hrm.commons.trainer.dto.mapper.UserTrainerDataMapper;
import com.sgic.hrm.commons.trainer.entity.mapper.UserTrainerMapper;
import com.sgic.hrm.trainer.service.UserTrainerService;

@RestController
@CrossOrigin(origins = "*")
public class UserTrainerController {
	@Autowired
	UserTrainerService userTrainerService;

	@GetMapping("/userTrainer/{id}")
	public ResponseEntity<UserTrainerData> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(UserTrainerMapper.maptoUserTrainerData(userTrainerService.getById(id)),
				HttpStatus.OK);
	}

	@GetMapping("/userTrainer")
	public ResponseEntity<List<UserTrainerData>> getAlluserTrainer() {
		return new ResponseEntity<>(UserTrainerMapper.mapToUserTrainerDataList(userTrainerService.getAlluserTrainer()),
				HttpStatus.OK);
	}

	@PostMapping("/userTrainer")
	public ResponseEntity<String> createuserTrainer(@RequestBody UserTrainerData userTrainerData) {
		if (userTrainerService.createuserTrainer(UserTrainerDataMapper.mapToTrainer(userTrainerData))) {
			return new ResponseEntity<>("User Trainer Creation Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("User Trainer Creation Failed ", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/userTrainer/{id}")
	public ResponseEntity<String> updateuserTrainer(@PathVariable(name = "id") Integer id,
			@RequestBody UserTrainerData userTrainerData) {
		if (userTrainerService.updateuserTrainer(UserTrainerDataMapper.mapToTrainer(userTrainerData), id)) {
			return new ResponseEntity<>("User Trainer Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("User Trainer Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/userTrainer/{id}")
	public ResponseEntity<String> deleteuserTrainer(@PathVariable(name = "id") Integer id) {
		if (userTrainerService.deleteuserTrainer(id)) {
			return new ResponseEntity<>("User Trainer Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("User Trainer Delete Failed ", HttpStatus.BAD_REQUEST);
	}
}
