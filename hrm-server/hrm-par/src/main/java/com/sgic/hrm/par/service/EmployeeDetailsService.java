package com.sgic.hrm.par.service;

import java.util.List;

import com.sgic.hrm.commons.entity.par.EmployeeDetails;

public interface EmployeeDetailsService {
	public List<EmployeeDetails> findByEmpName(String empName);
	
	public List<EmployeeDetails>findEmpDetails();
	
	public List<EmployeeDetails> getEmployeeByEmail(String email);
	

}
