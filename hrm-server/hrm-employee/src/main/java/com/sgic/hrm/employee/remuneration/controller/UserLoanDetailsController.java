package com.sgic.hrm.employee.remuneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.entity.UserLoanDetails; 
import com.sgic.hrm.employee.remuneration.service.UserLoanDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserLoanDetailsController {
	@Autowired
	private UserLoanDetailsService userLoanDetailsService;


	@GetMapping("/userloandetails")
	public List<UserLoanDetails> viewAll() {
		return userLoanDetailsService.getAllUserLoanDetails();
	}

	@GetMapping("/userloandetails/{username}")
	public List<UserLoanDetails> viewOneById(@PathVariable String username) {		
		return userLoanDetailsService.getSpecificUser(username);
	}
	
	@GetMapping(path = "/userloandetails/search", params= {"name"})
	public List<UserLoanDetails> viewByName(@RequestParam("name") String name){
			return userLoanDetailsService.getSpecificUserByName(name);
	}
	 
	
}
