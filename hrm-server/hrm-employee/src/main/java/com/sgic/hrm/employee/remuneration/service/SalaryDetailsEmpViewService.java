package com.sgic.hrm.employee.remuneration.service;

import java.util.List;

import com.sgic.hrm.commons.entity.SalaryDetailsEmpViewEntity;

public interface SalaryDetailsEmpViewService {

	public List<SalaryDetailsEmpViewEntity> getSalarydetails();
	
	public SalaryDetailsEmpViewEntity getSalaryDetailsForEmployee(Integer id);
}
