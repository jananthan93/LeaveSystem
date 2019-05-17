package com.sgic.hrm.trainee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.trainee.AttendType;

public interface AttendTypeService {

	boolean addAttendanceType(AttendType attendType);

	List<AttendType> getAttendanceType();

	boolean editAttendType(AttendType attendType, Integer id);

	boolean deleteAttendType(Integer id);

	AttendType getAttendTypeId(Integer id);
}
