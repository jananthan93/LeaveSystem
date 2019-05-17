package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.WelfareType;
import com.sgic.hrm.commons.repository.WelfareTypeRepository;
import com.sgic.hrm.employee.service.WelfareTypeService;

@Service
public class WelfareTypeServiceImpl implements WelfareTypeService {
	@Autowired
	private WelfareTypeRepository welfareTypeRepository;

	@Override
	public boolean addWelfareType(WelfareType welfareType) {
		welfareTypeRepository.save(welfareType);
		return true;
	}

	@Override
	public List<WelfareType> getAllWelfareType() {
		return welfareTypeRepository.findAll();
	}

	@Override
	public boolean editWelfareType(WelfareType welfareType) {
		boolean success = false;
		if (welfareTypeRepository.getOne(welfareType.getId()) != null) {
			welfareTypeRepository.save(welfareType);
			success = true;
		}
		return success;
	}

	@Override
	public boolean deleteWelfareType(Integer id) {
		WelfareType welfareType = welfareTypeRepository.getOne(id);
		if (welfareType.getId() == (id)) {
			welfareTypeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public WelfareType getById(Integer id) {
		return welfareTypeRepository.getOne(id);
	}

	@Override
	public WelfareType getOneWelfareType(Integer id) {
		return welfareTypeRepository.findById(id).orElse(null);
	}

	
	@Override
	public boolean updateWelfareType(Integer id, WelfareType welfareType) {
		if(welfareTypeRepository.getOne(id) !=null) {
			welfareType.setId(id);
			welfareTypeRepository.save(welfareType);
			return true;
		}
		return false;
	}
	

}
