package com.sgic.hrm.employee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.Vacancy;

public interface VacancyService {
	 boolean addVacancy(Vacancy vacancy);
	 
	   List<Vacancy> getAllVacancy();
	   
	   boolean editVacancy(Vacancy vacancy, Integer id);
	   
	   boolean deleteVacancy(Integer id);
}
