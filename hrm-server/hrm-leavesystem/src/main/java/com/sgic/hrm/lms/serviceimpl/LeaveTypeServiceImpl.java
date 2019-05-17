package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.LeaveType;
import com.sgic.hrm.commons.repository.LeaveTypeRepository;
import com.sgic.hrm.lms.service.LeaveTypeService;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

	@Autowired
	LeaveTypeRepository leaveTypeRepository;

	@Override
	public boolean createLeaveType(LeaveType leaveType) {
		if (leaveType != null) {
			leaveTypeRepository.save(leaveType);
			return true;
		}
		return false;
	}

	@Override
	public List<LeaveType> viewAllLeaveType() {
		return leaveTypeRepository.findAll();
	}

	@Override
	public boolean deleteLeaveType(Integer id) {
		if (leaveTypeRepository.getOne(id)!= null) {
			leaveTypeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateLeaveType(Integer id, LeaveType leaveType) {
		if (leaveTypeRepository.getOne(id) != null) {
			leaveType.setId(id);
			leaveTypeRepository.save(leaveType);
			return true;
		}
		return false;
	}

}
