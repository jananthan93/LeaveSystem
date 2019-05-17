package com.sgic.hrm.trainee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.trainee.AttendStatus;
import com.sgic.hrm.commons.entity.trainee.AttendType;
import com.sgic.hrm.commons.entity.trainee.AttendanceDetails;
import com.sgic.hrm.commons.entity.trainee.Trainee;

public interface AttendanceDetailsService {
	boolean addAttendanceDetails(AttendanceDetails attendanceDetails, Trainee trainee, AttendType attendType,
			AttendStatus attendStatus);

	List<AttendanceDetails> getAttendanceDetails();

	boolean editAttendDetails(AttendanceDetails attendanceDetails, Trainee trainee, AttendType attendType,
			AttendStatus attendStatus, Integer id);

	boolean deleteAttendDetails(Integer id);
	List <AttendanceDetails> getAttendanceDetailsByTrainee(Integer id);
}
