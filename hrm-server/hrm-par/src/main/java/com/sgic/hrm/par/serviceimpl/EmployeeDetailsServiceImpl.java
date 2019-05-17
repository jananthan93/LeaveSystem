package com.sgic.hrm.par.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.par.EmployeeDetails;
import com.sgic.hrm.commons.repository.par.EmployeeDetailsRepository;
import com.sgic.hrm.par.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
	@Autowired
	EmployeeDetailsRepository employeeDetailsRepo;

	@Override
	public List<EmployeeDetails> findByEmpName(String empName) {
		return employeeDetailsRepo.findByEmpName(empName);
	}

	@Override
	public List<EmployeeDetails> findEmpDetails() {
		// TODO Auto-generated method stub
		return employeeDetailsRepo.findAll();
	}

	@Override
	public List<EmployeeDetails> getEmployeeByEmail(String empId) {
		// TODO Auto-generated method stub
		return employeeDetailsRepo.findByEmpId(empId);
	}

	
	
}
