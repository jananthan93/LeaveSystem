package com.sgic.hrm.employee.remuneration.service;

import java.util.List;

import com.sgic.hrm.commons.entity.SalaryDetailsHRViewEntity;

public interface SalaryDetailsHRViewService {

	public List<SalaryDetailsHRViewEntity> viewSalaryDetails();

	public List<SalaryDetailsHRViewEntity> viewSalaryDetailsByName(String name);
}
