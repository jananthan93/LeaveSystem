package com.sgic.hrm.trainee.serviceimpl;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainee.AttendStatus;
import com.sgic.hrm.commons.entity.trainee.AttendType;
import com.sgic.hrm.commons.entity.trainee.AttendanceDetails;
import com.sgic.hrm.commons.entity.trainee.Trainee;
import com.sgic.hrm.commons.repository.trainee.AttendanceDetailsRepository;
import com.sgic.hrm.commons.repository.trainee.TraineeRepository;
import com.sgic.hrm.trainee.service.AttendanceDetailsService;

@Service
public class AttendanceDetailsServiceImpl implements AttendanceDetailsService {
	@Autowired
	private AttendanceDetailsRepository attendanceDetailsRepository;
	
	@Autowired
	private TraineeRepository traineeRepository;

	@Override
	public List<AttendanceDetails> getAttendanceDetails() {
		return attendanceDetailsRepository.findAll();
	}

	@Override
	public boolean deleteAttendDetails(Integer id) {
		if (attendanceDetailsRepository.getOne(id) != null) {
			attendanceDetailsRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean addAttendanceDetails(AttendanceDetails attendanceDetails, Trainee trainee, AttendType attendType,
			AttendStatus attendStatus) {
		attendanceDetails.setTrainee(trainee);
		attendanceDetails.setAttendantStatus(attendStatus);
		attendanceDetails.setAttendType(attendType);

		LocalTime start = LocalTime.of(attendanceDetails.getStartTime().getHours(),
				attendanceDetails.getStartTime().getMinutes());
		LocalTime end = LocalTime.of(attendanceDetails.getEndTime().getHours(),
				attendanceDetails.getEndTime().getMinutes());
		Duration duration = Duration.between(start, end);

//		duration get in long number of nano secounds
		attendanceDetails.setDuration(duration);
		attendanceDetailsRepository.save(attendanceDetails);
		return true;

	}

	@Override
	public boolean editAttendDetails(AttendanceDetails attendanceDetails, Trainee trainee, AttendType attendType,
			AttendStatus attendStatus, Integer id) {
		attendanceDetails.setTrainee(trainee);
		attendanceDetails.setAttendantStatus(attendStatus);
		attendanceDetails.setAttendType(attendType);
		if (attendanceDetailsRepository.getOne(id) != null) {
			attendanceDetailsRepository.save(attendanceDetails);
			return true;
		}
		return false;
	}

	@Override
	public List<AttendanceDetails> getAttendanceDetailsByTrainee(Integer id) {
		AttendanceDetails attendanceDetail;
		
		return attendanceDetailsRepository.findAttendanceDetailsByTrainee(traineeRepository.findTraineeById(id));
	}

}
