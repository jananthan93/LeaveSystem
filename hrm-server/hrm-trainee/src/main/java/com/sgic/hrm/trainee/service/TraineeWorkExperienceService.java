package com.sgic.hrm.trainee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.trainee.Trainee;
import com.sgic.hrm.commons.entity.trainee.TraineeWorkExperience;

public interface TraineeWorkExperienceService {
	boolean addWorkExperience(TraineeWorkExperience traineeWorkExperience, Trainee trainee);

	List<TraineeWorkExperience> getAllWorkExperience();

	boolean editWorkExperience(TraineeWorkExperience traineeWorkExperience, Trainee trainee, Integer id);

	boolean deleteWorkExperience(Integer id);

	TraineeWorkExperience getWorkExperienceById(int id);

	List<TraineeWorkExperience> getWorkExperienceByTraineeId(Integer uid);
}
