package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.District;

public interface DistrictService {
	
	boolean addDistrict(District district);
	  
	   List<District> getAllDistrict();
	   
	   boolean editDistrict(District district, Integer id);
	   
	   boolean deleteDistrict(Integer id);
	   
	   District getById(Integer id);


}
