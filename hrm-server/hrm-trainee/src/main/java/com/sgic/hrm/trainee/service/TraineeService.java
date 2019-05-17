package com.sgic.hrm.trainee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.trainee.TraineeDepartment;
import com.sgic.hrm.commons.entity.trainee.Trainee;

public interface TraineeService {
	public boolean addTrainee(Trainee trainee, TraineeDepartment traineeDepartment);

	List<Trainee> getTrainee();

	Trainee getTraineeById(Integer id);

	boolean editTrainee(Trainee trainee, TraineeDepartment traineeDepartment, Integer id);

	boolean deleteTrainee(Integer id);

	public Trainee findTraineeById(Integer id);

	public Trainee findByTraineeName(String fullName);

	public List<Trainee> findTraineeByEmployment(String employment);

	public List<Trainee> findTraineebyfullName(String fullName);
}
