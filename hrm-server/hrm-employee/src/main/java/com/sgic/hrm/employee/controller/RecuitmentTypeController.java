package com.sgic.hrm.employee.controller;

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

import com.sgic.hrm.commons.dto.RecruitmentTypeData;
import com.sgic.hrm.commons.dto.mapper.RecruitmentTypeDataMapper;
import com.sgic.hrm.commons.entity.RecruitmentType;
import com.sgic.hrm.employee.service.RecruitmentTypeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
public class RecuitmentTypeController {
	@Autowired
	private RecruitmentTypeService recruitmentService;

	@PostMapping("/recruitmentType")
	public HttpStatus createRecuitment(@RequestBody RecruitmentTypeData recruitmentData) {
		boolean test = recruitmentService.addRecruitment(RecruitmentTypeDataMapper.recruitmentDataMapper(recruitmentData));
		if (test) {
			return HttpStatus.CREATED;

		}

		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/recruitmentType")
	public ResponseEntity<List<RecruitmentType>> getRecuitment() {
		List<RecruitmentType> recuitment = recruitmentService.getAllRecruitment();
		ResponseEntity<List<RecruitmentType>> response = new ResponseEntity<>(recuitment, HttpStatus.OK);
		return response;
	}
	
//	@PutMapping("/recruitment/{id}")
//	public HttpStatus editRecuitment(@RequestBody Recruitment recuitment, @PathVariable("id") Integer id) {
//		boolean test = recruitmentService.editRecruitment(recuitment, id);
//		if (test) {
//			return HttpStatus.ACCEPTED;
//		}
//		return HttpStatus.BAD_REQUEST;
//
//	}
	@PutMapping("/recruitmentType/{id}")
	public ResponseEntity<String> updateRecuitment(@PathVariable(name="id") Integer id,@RequestBody RecruitmentTypeData recruitmentData){
		RecruitmentType recruitment=RecruitmentTypeDataMapper.recruitmentDataMapper(recruitmentData);
		if(recruitmentService.editRecruitment(recruitment, id))
		{
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/recruitmentType/{id}")
	public HttpStatus deleteRecuitment(@PathVariable("id") Integer id) {
		boolean test = recruitmentService.deleteRecruitment(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}
}
