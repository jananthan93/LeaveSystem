package com.sgic.hrm.trainee.service;

import java.util.List;
import java.util.Optional;

import com.sgic.hrm.commons.entity.trainee.TraineeReferee;
import com.sgic.hrm.commons.entity.trainee.Trainee;

public interface TraineeRefereeService {

	boolean addReferee(TraineeReferee traineeReferee, Trainee trainee);

	List<TraineeReferee> getAllReferee();

	boolean editReferee(TraineeReferee traineeReferee, int id, Trainee trainee);

	Optional<TraineeReferee> getRefereeById(int id);

	boolean deleteReferee(int id);

	List<TraineeReferee> getRefereeByTraineeId(Integer id);

}
