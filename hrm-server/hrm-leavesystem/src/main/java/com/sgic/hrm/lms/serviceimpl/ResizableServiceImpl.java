package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Resizable;
import com.sgic.hrm.commons.repository.ResizableRepository;
import com.sgic.hrm.lms.service.ResizableService;

@Service
public class ResizableServiceImpl implements ResizableService {
	@Autowired
	ResizableRepository resizableRepository;

	@Override
	public List<Resizable> getAllResizable() {
		
		return resizableRepository.findAll();
	}

	@Override
	public boolean addResizable(Resizable resizable) {
		resizableRepository.save(resizable);
		return true;
	}

	@Override
	public Resizable findByStartAndEnd(boolean beforeStart, boolean afterEnd) {

		return resizableRepository.findByBeforeStartAndAfterEnd(beforeStart, afterEnd);
	}
	

}
