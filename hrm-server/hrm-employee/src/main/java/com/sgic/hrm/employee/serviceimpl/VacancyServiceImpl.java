package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.Vacancy;
import com.sgic.hrm.commons.repository.VacancyRepository;
import com.sgic.hrm.employee.service.VacancyService;



@Service
public class VacancyServiceImpl implements VacancyService {
	@Autowired
	private VacancyRepository vacancyRepository;
	
	@Override
	public boolean addVacancy(Vacancy vacancy) {
		vacancyRepository.save(vacancy);
		return true;
	}

	@Override
	public List<Vacancy> getAllVacancy() {
		return vacancyRepository.findAll();
	}

	@Override
	public boolean editVacancy(Vacancy vacancy, Integer id) {
		boolean success = false;
		if (vacancyRepository.getOne(id) != null) {
			vacancy.setId(id);
			vacancyRepository.save(vacancy);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteVacancy(Integer id) {
		Vacancy vacancy = vacancyRepository.getOne(id);
		if (vacancy.getId() == (id)) {
			vacancyRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
