package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.WelfareType;

public interface WelfareTypeService {
	boolean addWelfareType(WelfareType welfareType);

	List<WelfareType> getAllWelfareType();

	boolean editWelfareType(WelfareType welfareType);

	boolean deleteWelfareType(Integer id);

	WelfareType getById(Integer id);

	WelfareType getOneWelfareType(Integer id);

	boolean updateWelfareType(Integer id, WelfareType welfareType);

}
