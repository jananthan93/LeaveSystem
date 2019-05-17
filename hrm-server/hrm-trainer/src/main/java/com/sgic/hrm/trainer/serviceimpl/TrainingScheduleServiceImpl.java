package com.sgic.hrm.trainer.serviceimpl;
//Done by Daminiya
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainer.TrainingSchedule;
import com.sgic.hrm.commons.trainer.repository.TrainingScheduleRepository;
import com.sgic.hrm.trainer.service.TrainingScheduleService;

@Service
public class TrainingScheduleServiceImpl implements TrainingScheduleService {
	@Autowired
	private TrainingScheduleRepository trainingScheduleRepository;

	@Override
	public boolean addTrainingSchedule(TrainingSchedule trainingSchedule) {
		trainingScheduleRepository.save(trainingSchedule);
		return true;
	}

	@Override
	public List<TrainingSchedule> getAllTrainingSchedule() {
		return trainingScheduleRepository.findAll();
	}

	@Override
	public boolean editTrainingSchedule(TrainingSchedule trainingSchedule) {
		boolean success = false;
		if (trainingScheduleRepository.getOne(trainingSchedule.getId()) != null) {
			trainingScheduleRepository.save(trainingSchedule);
			success = true;
		}
		return success;
	}

	@Override
	public boolean deleteTrainingSchedule(Integer id) {
		TrainingSchedule trainingSchedule = trainingScheduleRepository.getOne(id);
		if (trainingSchedule.getId() == (id)) {
			trainingScheduleRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public TrainingSchedule getById(Integer id) {
		return trainingScheduleRepository.getOne(id);
	}

	@Override
	public TrainingSchedule getOneTrainingSchedule(Integer id) {
		return trainingScheduleRepository.findById(id).orElse(null);
	}

	@Override
	public boolean updateTrainingSchedule(Integer id, TrainingSchedule trainingSchedule) {
		if (trainingScheduleRepository.getOne(id) != null) {
			trainingSchedule.setId(id);
			trainingScheduleRepository.save(trainingSchedule);
			return true;
		}
		return false;
	}

}
