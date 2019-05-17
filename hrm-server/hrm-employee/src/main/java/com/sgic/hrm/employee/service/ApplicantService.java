package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.Applicant;



public interface ApplicantService {
	boolean addApplicant(Applicant applicant);
	  
	   List<Applicant> getAllApplicant();
	   
	   boolean editApplicant(Applicant applicant, Integer id);
	   
	   boolean deleteApplicant(Integer id);
	   
	 //  Applicant getById(Integer id);

}
