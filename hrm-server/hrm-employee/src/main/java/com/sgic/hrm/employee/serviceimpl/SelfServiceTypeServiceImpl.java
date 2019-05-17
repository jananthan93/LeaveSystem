package com.sgic.hrm.employee.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.SelfServiceType;
import com.sgic.hrm.commons.repository.SelfServiceTypeRepository;
import com.sgic.hrm.employee.service.SelfServiceTypeService;

@Service
public class SelfServiceTypeServiceImpl implements SelfServiceTypeService {

	@Autowired
	private SelfServiceTypeRepository selfServiceTypeRepository;

	@Override
	public List<SelfServiceType> viewSelfServiceType() {
		return selfServiceTypeRepository.findAll();
	}

	@Override
	public boolean addSelfServiceType(SelfServiceType selfServiceType) {
		selfServiceTypeRepository.save(selfServiceType);
		return true;
	}

	@Override
	public boolean editSelfServiceType(SelfServiceType selfServiceType, Integer id) {
		if (selfServiceTypeRepository.getOne(id) != null) {
			selfServiceType.setId(id);
			selfServiceTypeRepository.save(selfServiceType);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteSelfServiceType(Integer id) {
		if (selfServiceTypeRepository.getOne(id) != null) {
			selfServiceTypeRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
