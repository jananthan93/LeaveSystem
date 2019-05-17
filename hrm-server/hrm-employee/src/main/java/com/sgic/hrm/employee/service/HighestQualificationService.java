package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.HighestQualification;



public interface HighestQualificationService {
	boolean addHighestQualification(HighestQualification highestQualification);
	  
	   List<HighestQualification> getAllHighestQualification();
	   
	   boolean editHighestQualification(HighestQualification highestQualification, Integer id);
	   
	   boolean deleteHighestQualification(Integer id);
}
