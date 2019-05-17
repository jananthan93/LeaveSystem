package com.sgic.hrm.employee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.SelfService;

public interface SelfServiceService {
	List<SelfService> viewSelfService();

	boolean addSelfService(SelfService selfService);

	boolean editSelfService(SelfService selfService, Integer id);

	boolean deleteSelfService(Integer id);
	
	List<SelfService> findByUserId(Integer id);
	
	public List<SelfService> getSpecificUser(String name);
	
	List<SelfService> findByStatusNot(String status);
}
