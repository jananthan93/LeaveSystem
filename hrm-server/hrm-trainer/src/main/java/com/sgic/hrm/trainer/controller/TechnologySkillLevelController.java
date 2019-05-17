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
import com.sgic.hrm.commons.trainer.dto.TechnologySkillLevelDto;
import com.sgic.hrm.commons.trainer.dto.mapper.TechnologySkillLevelDtoMapper;
import com.sgic.hrm.commons.trainer.entity.mapper.TechnologySkillLevelMapper;
import com.sgic.hrm.trainer.service.TechnologySkillLevelService;

@RestController
@CrossOrigin(origins = "*")
public class TechnologySkillLevelController {
	@Autowired
	TechnologySkillLevelService technologySkillLevelService;

	@GetMapping("/technologySkillLevel/{id}")
	public ResponseEntity<TechnologySkillLevelDto> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(
				TechnologySkillLevelMapper.mapToTechnologySkillLevelDTO(technologySkillLevelService.getById(id)),
				HttpStatus.OK);
	}

	@GetMapping("/technologySkillLevel")
	public ResponseEntity<List<TechnologySkillLevelDto>> getAllRecordOfEmployment() {
		return new ResponseEntity<>(TechnologySkillLevelMapper
				.mapToTechnologySkillLevelDTO(technologySkillLevelService.getAllTechnologySkillLevel()), HttpStatus.OK);
	}

	@PostMapping("/technologySkillLevel")
	public ResponseEntity<String> createTechnologySkillLevel(
			@RequestBody TechnologySkillLevelDto technologySkillLevelDto) {
		if (technologySkillLevelService.createTechnologySkillLevel(
				TechnologySkillLevelDtoMapper.mapToTechnologySkillLevel(technologySkillLevelDto))) {
			return new ResponseEntity<>("Technology Skill Level Create Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Technology Skill Level Create Failed ", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/technologySkillLevel/{id}")
	public ResponseEntity<String> updateTechnologySkillLevel(@PathVariable(name = "id") Integer id,
			@RequestBody TechnologySkillLevelDto technologySkillLevelDto) {
		if (technologySkillLevelService.updateTechnologySkillLevel(
				TechnologySkillLevelDtoMapper.mapToTechnologySkillLevel(technologySkillLevelDto), id)) {
			return new ResponseEntity<>("Technology Skill Level Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Technology Skill Level Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/technologySkillLevel/{id}")
	public ResponseEntity<String> deleteTechnologySkillLevel(@PathVariable(name = "id") Integer id) {
		if (technologySkillLevelService.deleteTechnologySkillLevel(id)) {
			return new ResponseEntity<>("Technology Skill Level Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Technology Skill Level Delete Failed ", HttpStatus.BAD_REQUEST);
	}
}
