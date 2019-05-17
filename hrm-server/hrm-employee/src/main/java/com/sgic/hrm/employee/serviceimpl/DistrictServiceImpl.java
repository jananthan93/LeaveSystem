package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.District;
import com.sgic.hrm.commons.repository.DistrictRepository;
import com.sgic.hrm.employee.service.DistrictService;
@Service
public class DistrictServiceImpl implements DistrictService  {
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Override
	public boolean addDistrict(District district) {
		districtRepository.save(district);
		return true;
	}

	@Override
	public List<District> getAllDistrict() {
		return districtRepository.findAll();
	}

	@Override
	public boolean editDistrict(District district, Integer id) {
		boolean success = false;
		if (districtRepository.getOne(id) != null) {
			district.setId(id);
			districtRepository.save(district);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteDistrict(Integer id) {
		District district = districtRepository.getOne(id);
		if (district.getId() == (id)) {
			districtRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public District getById(Integer id) {
		return districtRepository.getOne(id);
	}


}
