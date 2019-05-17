package com.sgic.hrm.trainer.service;

//done by_Sujaany
import java.util.List;

import com.sgic.hrm.commons.entity.trainer.TechnologySkillLevel;

public interface TechnologySkillLevelService {

	List<TechnologySkillLevel> getAllTechnologySkillLevel();

	boolean createTechnologySkillLevel(TechnologySkillLevel technologySkillLevel);

	boolean deleteTechnologySkillLevel(Integer id);

	boolean updateTechnologySkillLevel(TechnologySkillLevel technologySkillLevel, Integer id);

	TechnologySkillLevel getById(Integer id);
}
