package com.sgic.hrm.trainee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainee.AttendType;
import com.sgic.hrm.commons.repository.trainee.AttendTypeRepository;
import com.sgic.hrm.trainee.service.AttendTypeService;

@Service
public class AttendTypeServiceImpl implements AttendTypeService {
	@Autowired
	private AttendTypeRepository attendTypeRepository;

	@Override
	public boolean addAttendanceType(AttendType attendType) {
		attendTypeRepository.save(attendType);
		return true;
	}

	@Override
	public List<AttendType> getAttendanceType() {
		return attendTypeRepository.findAll();
	}

	@Override
	public boolean deleteAttendType(Integer id) {
		if (attendTypeRepository.getOne(id) != null) {
			attendTypeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean editAttendType(AttendType attendType, Integer id) {
		if (attendTypeRepository.getOne(id) != null) {
			attendTypeRepository.save(attendType);
			return true;
		}
		return false;
	}

	@Override
	public AttendType getAttendTypeId(Integer id) {
		return attendTypeRepository.findAttendTypeById(id);
	}

}
