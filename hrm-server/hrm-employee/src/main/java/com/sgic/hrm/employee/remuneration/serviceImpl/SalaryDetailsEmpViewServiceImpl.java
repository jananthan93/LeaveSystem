package com.sgic.hrm.employee.remuneration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.SalaryDetailsEmpViewEntity;
import com.sgic.hrm.commons.repository.SalaryDetailsEmpViewRepository;
import com.sgic.hrm.employee.remuneration.service.SalaryDetailsEmpViewService;

@Service
public class SalaryDetailsEmpViewServiceImpl implements SalaryDetailsEmpViewService {

	@Autowired
	SalaryDetailsEmpViewRepository salaryDetailsEmpViewRepository;
	@Override
	public List<SalaryDetailsEmpViewEntity> getSalarydetails() {
		// TODO Auto-generated method stub
		return salaryDetailsEmpViewRepository.findAll();
	}
	@Override
	public SalaryDetailsEmpViewEntity getSalaryDetailsForEmployee(Integer id) {
		// TODO Auto-generated method stub
		return salaryDetailsEmpViewRepository.findDetailsByEmpId(id);
	}

}
