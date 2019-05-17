package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.TerminationType;

public interface TerminationTypeService {
	boolean addTerminationType(TerminationType terminationType);

	  List<TerminationType> getAllTerminationType();

	  boolean editTerminationType(TerminationType terminationType, Integer id);

	  boolean deleteTerminationType(Integer id);

	  TerminationType getById(Integer id);

}
