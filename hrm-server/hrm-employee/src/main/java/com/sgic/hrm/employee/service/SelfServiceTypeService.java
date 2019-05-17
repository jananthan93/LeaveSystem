package com.sgic.hrm.employee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.SelfServiceType;

public interface SelfServiceTypeService {

	List<SelfServiceType> viewSelfServiceType();

	boolean addSelfServiceType(SelfServiceType selfServiceType);

	boolean editSelfServiceType(SelfServiceType selfServiceType, Integer id);

	boolean deleteSelfServiceType(Integer id);
}
