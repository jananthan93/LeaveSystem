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

import com.sgic.hrm.commons.trainer.dto.SkillData;
import com.sgic.hrm.commons.trainer.dto.mapper.SkillDataMapper;
import com.sgic.hrm.commons.trainer.entity.mapper.SkillMapper;
import com.sgic.hrm.trainer.service.SkillService;

@RestController
@CrossOrigin(origins = "*")
public class SkillController {
	@Autowired
	SkillService skillService;

	@GetMapping("/skill/{id}")
	public ResponseEntity<SkillData> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(SkillMapper.mapToSkillDTO(skillService.getById(id)), HttpStatus.OK);
	}

	@GetMapping("/skill")
	public ResponseEntity<List<SkillData>> getAllSkill() {
		return new ResponseEntity<>(SkillMapper.mapToSkillDTOList(skillService.getAllSkill()), HttpStatus.OK);
	}

	@PostMapping("/skill")
	public ResponseEntity<String> createSkill(@RequestBody SkillData skillData) {
		if (skillService.createSkill(SkillDataMapper.mapToSkill(skillData))) {
			return new ResponseEntity<>("Skill Creation Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Skill Creation Failed ", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/skill/{id}")
	public ResponseEntity<String> updateSkill(@PathVariable(name = "id") Integer id, @RequestBody SkillData skillData) {
		if (skillService.updateSkill(SkillDataMapper.mapToSkill(skillData), id)) {
			return new ResponseEntity<>("Skill Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Skill Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/skill/{id}")
	public ResponseEntity<String> deleteSkill(@PathVariable(name = "id") Integer id) {
		if (skillService.deleteSkill(id)) {
			return new ResponseEntity<>("Skill Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Skill Delete Failed ", HttpStatus.BAD_REQUEST);
	}
}
