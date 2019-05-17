package com.sgic.hrm.trainer.service;

//done by_Sujaany
import java.util.List;
import com.sgic.hrm.commons.entity.trainer.Trainer;

public interface TrainerService {
	List<Trainer> getAllTrainer();
	
	boolean createTrainer (Trainer trainer);

	boolean deleteTrainer(Integer id);

	boolean updateTrainer(Trainer trainer, Integer id);
	
	Trainer getById(Integer id);
}
