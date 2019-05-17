package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.RecruitmentType;


public interface RecruitmentTypeService {
	 boolean addRecruitment(RecruitmentType recruitment);
	  
	   List<RecruitmentType> getAllRecruitment();
	   
	   boolean editRecruitment(RecruitmentType recruitment, Integer id);
	   
	   boolean deleteRecruitment(Integer id);
}
