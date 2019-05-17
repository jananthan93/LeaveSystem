package com.sgic.hrm.trainer.serviceimpl;

//done by_Sujaany
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainer.UserTrainer;
import com.sgic.hrm.commons.trainer.repository.UserTrainerRepository;
import com.sgic.hrm.trainer.service.UserTrainerService;

@Service
public class UserTrainerServiceImpl implements UserTrainerService {
	@Autowired
	private UserTrainerRepository userTrainerRepository;

	@Override
	public List<UserTrainer> getAlluserTrainer() {
		return userTrainerRepository.findAll();
	}

	@Override
	public boolean createuserTrainer(UserTrainer userTrainer) {
		userTrainerRepository.save(userTrainer);
		return true;
	}

	@Override
	public boolean deleteuserTrainer(Integer id) {
		userTrainerRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean updateuserTrainer(UserTrainer userTrainer, Integer id) {
		if (userTrainerRepository.getOne(id) != null) {
			userTrainer.setId(id);
			userTrainerRepository.save(userTrainer);
			return true;
		}
		return false;
	}

	@Override
	public UserTrainer getById(Integer id) {
		return userTrainerRepository.findById(id).orElse(null);
	}
}
