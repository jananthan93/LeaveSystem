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

import com.sgic.hrm.commons.dto.VacancyData;
import com.sgic.hrm.commons.dto.VacancySaveData;
import com.sgic.hrm.commons.dto.mapper.VacancyDataMapper;
import com.sgic.hrm.commons.entity.Vacancy;
import com.sgic.hrm.employee.service.VacancyService;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class VacancyController {
	@Autowired
	private VacancyService vacancyService;

	@GetMapping("/vacancy")
	public ResponseEntity<List<Vacancy>> getVacancy() {
		List<Vacancy> vacancy = vacancyService.getAllVacancy();
		ResponseEntity<List<Vacancy>> response = new ResponseEntity<>(vacancy, HttpStatus.OK);
		return response;
	}

	@PostMapping("/vacancysave")
	public HttpStatus postVacancy(@RequestBody VacancySaveData vacancySaveData) {

		boolean test =vacancyService.addVacancy(
				VacancyDataMapper.vacancySaveDataMapper(vacancySaveData));
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping("/vacancy/{id}")
	public ResponseEntity<String> updateVacancy(@PathVariable(name="id") Integer id,@RequestBody VacancyData vacancyData){
		Vacancy vacancy=VacancyDataMapper.vacancyDataMapper(vacancyData);
		if(vacancyService.editVacancy(vacancy, id))
		{
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/vacancy/{id}")
	public HttpStatus deleteVacancy(@PathVariable("id") Integer vacancy_id) {
		boolean test = vacancyService.deleteVacancy(vacancy_id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}
}
