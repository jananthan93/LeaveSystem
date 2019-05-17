package com.sgic.hrm.trainer.service;

//done by_Sujaany
import java.util.List;
import com.sgic.hrm.commons.entity.trainer.UserTrainer;

public interface UserTrainerService {
	
	List<UserTrainer> getAlluserTrainer();
	
	boolean createuserTrainer (UserTrainer userTrainer);

	boolean deleteuserTrainer(Integer id);

	boolean updateuserTrainer(UserTrainer userTrainer, Integer id);
	
	UserTrainer getById(Integer id);
}
