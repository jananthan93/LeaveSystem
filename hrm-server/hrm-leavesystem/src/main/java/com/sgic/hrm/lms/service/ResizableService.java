package com.sgic.hrm.lms.service;

import java.util.List;

import com.sgic.hrm.commons.entity.Resizable;

public interface ResizableService {
	List<Resizable> getAllResizable();
	boolean addResizable(Resizable resizable);
	Resizable findByStartAndEnd(boolean beforeStart, boolean afterEnd);

}
