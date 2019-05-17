package com.sgic.hrm.employee.remuneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.IndividualWelfareDto;
import com.sgic.hrm.commons.entity.mapper.IndividualWelfareEntityMapper;
import com.sgic.hrm.employee.remuneration.service.BenefitsAllowancesService;

@RestController
@RequestMapping("/benefits")
@CrossOrigin(origins = "http://localhost:4200")
public class BenefitsAllowancesController {

	@Autowired
	private BenefitsAllowancesService benefitsAllowancesService;

	@GetMapping
	public List<IndividualWelfareDto> viewBenefitsAllowances() {
		return IndividualWelfareEntityMapper.mapIndividualWelfareEntityListToIndividualWelfareDtoList(
				benefitsAllowancesService.getBenefitsAllowances());
	}

	@GetMapping(path = "/search", params = { "id" })
	public IndividualWelfareDto viewBenefits(@RequestParam("id") Integer id) {
		return IndividualWelfareEntityMapper
				.mapIndividualWelfareEntityToIndividualWelfareDto(benefitsAllowancesService.viewById(id));
	}

	@GetMapping("/{id}")
	public IndividualWelfareDto getBenefitsAllowencesByWelfareEventID(@PathVariable Integer id) {
		return IndividualWelfareEntityMapper
				.mapIndividualWelfareEntityToIndividualWelfareDto(benefitsAllowancesService.viewByWelfareEventId(id));
	}
}
