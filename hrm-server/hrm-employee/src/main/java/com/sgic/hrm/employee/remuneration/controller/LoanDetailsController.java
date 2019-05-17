package com.sgic.hrm.employee.remuneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.entity.LoanDetailsEntity;
import com.sgic.hrm.employee.remuneration.service.LoanDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoanDetailsController {
	@Autowired
	private LoanDetailsService loanDetailsService;

	@GetMapping("/loandetails")
	public List<LoanDetailsEntity> viewAll() {
		return loanDetailsService.getAllLoanDetails();
	}
}
