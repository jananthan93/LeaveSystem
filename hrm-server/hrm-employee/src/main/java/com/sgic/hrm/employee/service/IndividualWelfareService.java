package com.sgic.hrm.employee.service;

import java.util.List;


import com.sgic.hrm.commons.entity.IndividualWelfare;

public interface IndividualWelfareService {
	
	public List<IndividualWelfare> getAllIndividualWelfare();
	
	public boolean createIndividualWelfare (IndividualWelfare individualWelfare);

	public boolean deleteIndividualWelfare(Integer id);

	public boolean updateIndividualWelfare(IndividualWelfare generalWelfare, Integer id);
	
	public IndividualWelfare getById(Integer id);

}
