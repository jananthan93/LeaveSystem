package com.sgic.hrm.trainer.service;
//done by Daminiya
import java.util.List;

import com.sgic.hrm.commons.entity.trainer.TrainingSchedule;

public interface TrainingScheduleService {
	boolean addTrainingSchedule(TrainingSchedule trainingSchedule);

	List<TrainingSchedule> getAllTrainingSchedule();

	boolean editTrainingSchedule(TrainingSchedule trainingSchedule);

	boolean deleteTrainingSchedule(Integer id);

	TrainingSchedule getById(Integer id);

	TrainingSchedule getOneTrainingSchedule(Integer id);

	boolean updateTrainingSchedule(Integer id, TrainingSchedule trainingSchedule);
}
