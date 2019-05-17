package com.sgic.hrm.employee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.ExperienceLetter;

public interface ExperienceLetterService {

  public List<ExperienceLetter> getExperienceLetter();

  public void createExperienceLetter(ExperienceLetter experienceLetter);

  boolean updateExperienceLetter(ExperienceLetter experienceLetter, Integer id);

  public void deleteExperienceLetter(Integer id);
}
