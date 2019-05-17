package com.sgic.hrm.employee.remuneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.SalaryDetailsEmpDto;
import com.sgic.hrm.commons.entity.mapper.SalaryDetailsEmpEntityMapper;
import com.sgic.hrm.employee.remuneration.service.SalaryDetailsEmpViewService;

@RestController
@RequestMapping("/salarydetailsempview")
@CrossOrigin(origins = "http://localhost:4200")
public class SlaryDetailsEmpViewController {

	@Autowired
	SalaryDetailsEmpViewService salaryDetailsEmpViewService;

	@GetMapping
	public List<SalaryDetailsEmpDto> viewSalaryDetails() {
		return SalaryDetailsEmpEntityMapper.mapSalaryDetailsEmpDtoListToSalaryDetailsEntityList(salaryDetailsEmpViewService.getSalarydetails());
	}

	@GetMapping("/{id}")
	public SalaryDetailsEmpDto viewSalaryDetailsById(@PathVariable Integer id) {
		return SalaryDetailsEmpEntityMapper.mapSalaryDetailsEmpEntityToSalaryDetailsEmpDto(salaryDetailsEmpViewService.getSalaryDetailsForEmployee(id));
	}
}
