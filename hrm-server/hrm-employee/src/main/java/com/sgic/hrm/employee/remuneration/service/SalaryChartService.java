package com.sgic.hrm.employee.remuneration.service;

import java.util.List;

import com.sgic.hrm.commons.entity.SalaryChartEntity;

public interface SalaryChartService {

	public List<SalaryChartEntity> viewSalaryChart();

	public List<SalaryChartEntity> viewByEmpName(String name);
	
	public SalaryChartEntity viewSalaryChartEmployee(Integer id);
	
	public SalaryChartEntity viewByName(String name);
}
