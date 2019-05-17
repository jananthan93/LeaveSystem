package com.sgic.hrm.login.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TestRestAPIs { 
	
	@GetMapping("/api/test/employee")
	@PreAuthorize("hasRole('EMPLOYEE') or hasRole('HR')")
	public String employeeAccess() {
		return ">>> Employee Contents!";
	}
	@GetMapping("/api/test/hr")
	@PreAuthorize("hasRole('HR')")
	public String hrAccess() {
		return ">>> HR Contents";
	}
}