package com.sgic.hrm.trainer.serviceimpl;

//done by_Sujaany
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainer.TechnologySkillLevel;
import com.sgic.hrm.commons.trainer.repository.TechnologySkillLevelRepository;
import com.sgic.hrm.trainer.service.TechnologySkillLevelService;

@Service
public class TechnologySkillLevelServiceImpl implements TechnologySkillLevelService {
	@Autowired
	private TechnologySkillLevelRepository technologySkillLevelRepository;

	@Override
	public List<TechnologySkillLevel> getAllTechnologySkillLevel() {
		return technologySkillLevelRepository.findAll();
	}

	@Override
	public boolean createTechnologySkillLevel(TechnologySkillLevel technologySkillLevel) {
		technologySkillLevelRepository.save(technologySkillLevel);
		return true;
	}

	@Override
	public boolean deleteTechnologySkillLevel(Integer id) {
		technologySkillLevelRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean updateTechnologySkillLevel(TechnologySkillLevel technologySkillLevel, Integer id) {
		if (technologySkillLevelRepository.getOne(id) != null) {
			technologySkillLevel.setId(id);
			technologySkillLevelRepository.save(technologySkillLevel);
			return true;
		}
		return false;
	}

	@Override
	public TechnologySkillLevel getById(Integer id) {
		return technologySkillLevelRepository.findById(id).orElse(null);
	}
}
