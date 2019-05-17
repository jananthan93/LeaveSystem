package com.sgic.hrm.employee.remuneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.SalaryDetailsDto;
import com.sgic.hrm.commons.entity.mapper.SalaryDetailsEntityMapper;
import com.sgic.hrm.employee.remuneration.service.SalaryDetailsHRViewService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/salarydetailsHRview")
@RestController
public class SalaryDetailsHRViewController {

	@Autowired
	SalaryDetailsHRViewService salaryDetailsHRViewService;

	@GetMapping
	public List<SalaryDetailsDto> getSalaryDetails() {
		return SalaryDetailsEntityMapper
				.mapSalaryDetailsEntityListToSalaryDetailsDtoList(salaryDetailsHRViewService.viewSalaryDetails());
	}

	@GetMapping(path = "/search", params = { "name" })
	public List<SalaryDetailsDto> getSalaryDetailsByID(@RequestParam("name") String name) {
		return SalaryDetailsEntityMapper.mapSalaryDetailsEntityListToSalaryDetailsDtoList(
				salaryDetailsHRViewService.viewSalaryDetailsByName(name));
	}

}
