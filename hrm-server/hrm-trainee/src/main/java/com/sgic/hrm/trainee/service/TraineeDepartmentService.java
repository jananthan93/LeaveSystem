package com.sgic.hrm.trainee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.trainee.TraineeDepartment;

public interface TraineeDepartmentService {
	boolean addDepartment(TraineeDepartment traineeDepartment);

	List<TraineeDepartment> getAllDepartment();

	boolean editDepartment(TraineeDepartment traineeDepartment, int id);

	TraineeDepartment findByDepartmentId(Integer id);

	boolean deleteDepartment(int id);

}
