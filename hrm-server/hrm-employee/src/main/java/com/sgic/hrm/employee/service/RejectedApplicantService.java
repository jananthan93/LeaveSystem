package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.RejectedApplicant;



public interface RejectedApplicantService {
	
	boolean addRejectedApplicant(RejectedApplicant rejectedApplicant);
	  
	   List<RejectedApplicant> getAllRejectedApplicant();
	   
	   boolean editRejectedApplicant(RejectedApplicant rejectedApplicant, Integer id);
	   
	   boolean deleteRejectedApplicant(Integer id);
	   
	   RejectedApplicant getById(Integer id);


}
