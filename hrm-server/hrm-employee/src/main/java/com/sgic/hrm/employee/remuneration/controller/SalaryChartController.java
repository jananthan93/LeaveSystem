package com.sgic.hrm.employee.remuneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.SalaryChartDto;
import com.sgic.hrm.commons.entity.mapper.SalaryChartEntityMapper;
import com.sgic.hrm.employee.remuneration.service.SalaryChartService;

@RestController
@RequestMapping("/salarychart")
@CrossOrigin(origins = "http://localhost:4200")
public class SalaryChartController {

	@Autowired
	private SalaryChartService salaryChartService;

	@GetMapping
	public List<SalaryChartDto> getSalaryChart() {
		return SalaryChartEntityMapper
				.mapSalaryChartEntityListToSalaryChartDtoList(salaryChartService.viewSalaryChart());
	}

	@GetMapping(path = "/search", params = { "name" })
	public List<SalaryChartDto> viewSalaryChart(@RequestParam("name") String name) {
		return SalaryChartEntityMapper.mapSalaryChartEntityListToSalaryChartDtoList(salaryChartService.viewByEmpName(name));
	}
	
//	@GetMapping(path = "/{id}")
//	public SalaryChartDto getSalaryChartEmployee(@PathVariable("id") Integer id) {
//		return SalaryChartEntityMapper.mapSalaryChartEntityToSalartChartDto(salaryChartService.viewSalaryChartEmployee(id));
//	}
	
	@GetMapping("/{name}")
	public SalaryChartDto getSalaryChartByUserName(@PathVariable String name) {
		return SalaryChartEntityMapper.mapSalaryChartEntityToSalartChartDto(salaryChartService.viewByName(name));
	
	}
}
