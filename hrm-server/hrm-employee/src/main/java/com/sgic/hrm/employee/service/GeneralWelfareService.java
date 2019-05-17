package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.GeneralWelfare;

public interface GeneralWelfareService {

	public List<GeneralWelfare> getAllGeneralWelfare();

	public boolean createGeneralWelfare(GeneralWelfare generalWelfare);

	public boolean updateGeneralWelfare(GeneralWelfare generalWelfare, Integer id);

	public boolean deleteGeneralWelfare(Integer id);
	
	public GeneralWelfare getById(Integer id);

}
