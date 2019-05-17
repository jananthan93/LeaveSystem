package com.sgic.hrm.trainer.serviceimpl;

//done by_Sujaany
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.trainer.Skill;
import com.sgic.hrm.commons.trainer.repository.SkillRepository;
import com.sgic.hrm.trainer.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillRepository skillRepository;

	@Override
	public List<Skill> getAllSkill() {
		return skillRepository.findAll();
	}

	@Override
	public boolean createSkill(Skill skill) {
		skillRepository.save(skill);
		return true;
	}

	@Override
	public boolean deleteSkill(Integer id) {
		skillRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean updateSkill(Skill skill, Integer id) {
		if (skillRepository.getOne(id) != null) {
			skill.setId(id);
			skillRepository.save(skill);
			return true;
		}
		return false;
	}

	@Override
	public Skill getById(Integer id) {
		return skillRepository.findById(id).orElse(null);
	}
}
