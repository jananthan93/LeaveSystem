package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.WelfareEvent;
import com.sgic.hrm.commons.repository.WelfareEventRepository;
import com.sgic.hrm.employee.service.WelfareEventService;
@Service
public class WelfareEventServiceImpl  implements WelfareEventService{

	@Autowired
	private WelfareEventRepository welfareEventRepository;

	@Override
	public boolean addWelfareEvent(WelfareEvent welfareEvent) {
		welfareEventRepository.save(welfareEvent);
		return true;
	}

	@Override
	public List<WelfareEvent> getAllWelfareEvent() {
		return welfareEventRepository.findAll();
	}

	@Override
	public boolean editWelfareEvent(WelfareEvent welfareEvent) {
		boolean success = false;
		if (welfareEventRepository.getOne(welfareEvent.getId()) != null) {
			welfareEventRepository.save(welfareEvent);
			success = true;
		}
		return success;
	}

	@Override
	public boolean deleteWelfareEvent(Integer id) {
		WelfareEvent welfareEvent = welfareEventRepository.getOne(id);
		if (welfareEvent.getId() == (id)) {
			welfareEventRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public WelfareEvent getById(Integer id) {
		return welfareEventRepository.getOne(id);
	}

	@Override
	public WelfareEvent getOneWelfareEvent(Integer id) {
		return welfareEventRepository.findById(id).orElse(null);
	}

	
	@Override
	public boolean updateWelfareEvent(Integer id, WelfareEvent welfareEvent) {
		if(welfareEventRepository.getOne(id) !=null) {
			welfareEvent.setId(id);
			welfareEventRepository.save(welfareEvent);
			return true;
		}
		return false;
	}

	
	

}
