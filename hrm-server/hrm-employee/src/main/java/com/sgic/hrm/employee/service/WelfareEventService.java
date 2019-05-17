package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.WelfareEvent;

public interface WelfareEventService {
	boolean addWelfareEvent(WelfareEvent welfareEvent);

	List<WelfareEvent> getAllWelfareEvent();

	boolean editWelfareEvent(WelfareEvent welfareEvent);

	boolean deleteWelfareEvent(Integer id);

	WelfareEvent getById(Integer id);

	WelfareEvent getOneWelfareEvent(Integer id);

	boolean updateWelfareEvent(Integer id, WelfareEvent welfareEvent);


}
