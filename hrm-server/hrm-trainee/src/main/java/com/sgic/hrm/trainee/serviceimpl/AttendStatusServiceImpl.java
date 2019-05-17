package com.sgic.hrm.trainee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainee.AttendStatus;
import com.sgic.hrm.commons.repository.trainee.AttendStatusRepository;
import com.sgic.hrm.trainee.service.AttendStatusService;

@Service
public class AttendStatusServiceImpl implements AttendStatusService {
	@Autowired
	AttendStatusRepository attendStatusRepository;

	@Override
	public boolean addAttendanceStatus(AttendStatus attendStatus) {
		attendStatusRepository.save(attendStatus);
		return true;
	}

	@Override
	public List<AttendStatus> getAttendanceStatus() {
		return attendStatusRepository.findAll();

	}

	@Override
	public boolean editAttendStatus(AttendStatus attendStatus, Integer id) {
		if (attendStatusRepository.getOne(id) != null) {
			attendStatusRepository.save(attendStatus);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAttendStatus(Integer id) {
		if (attendStatusRepository.getOne(id) != null) {
			attendStatusRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public AttendStatus getAttendStatusId(Integer id) {
		return attendStatusRepository.findAttendStatusById(id);
	}

}
