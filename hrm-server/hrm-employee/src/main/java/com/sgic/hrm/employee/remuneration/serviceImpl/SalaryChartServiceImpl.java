package com.sgic.hrm.employee.remuneration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.SalaryChartEntity;
import com.sgic.hrm.commons.repository.SalaryChartRepository;
import com.sgic.hrm.employee.remuneration.service.SalaryChartService;

@Service
public class SalaryChartServiceImpl implements SalaryChartService {

	@Autowired
	SalaryChartRepository salaryChartRepository;

	@Override
	public List<SalaryChartEntity> viewSalaryChart() {
		// TODO Auto-generated method stub
		return salaryChartRepository.findAll();
	}

	@Override
	public List<SalaryChartEntity> viewByEmpName(String name) {
		// TODO Auto-generated method stub
		return salaryChartRepository.findByEmpName(name);
	}

	@Override
	public SalaryChartEntity viewSalaryChartEmployee(Integer id) {
		// TODO Auto-generated method stub
		return salaryChartRepository.getOne(id);
	}

	@Override
	public SalaryChartEntity viewByName(String name) {
		// TODO Auto-generated method stub
		return salaryChartRepository.findByUserName(name);
		
	}
}
