package com.sgic.hrm.employee.remuneration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.SalaryDetailsHRViewEntity;
import com.sgic.hrm.commons.repository.SalaryDetailsHRViewRepository;
import com.sgic.hrm.employee.remuneration.service.SalaryDetailsHRViewService;

@Service
public class SalaryDetailsHRViewServiceImpl implements SalaryDetailsHRViewService{

	@Autowired
	SalaryDetailsHRViewRepository salaryDetailsHRViewRepository;
	@Override
	public List<SalaryDetailsHRViewEntity> viewSalaryDetails() {
		// TODO Auto-generated method stub
		return salaryDetailsHRViewRepository.findAll();
	}
	@Override
	public List<SalaryDetailsHRViewEntity> viewSalaryDetailsByName(String name) {
		// TODO Auto-generated method stub
		return salaryDetailsHRViewRepository.findSalaryDetailsByEmpName(name);
	}

}
