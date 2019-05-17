package com.sgic.hrm.employee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.RequestExperienceLetter;

public interface RequestExperienceLetterService {

  List<RequestExperienceLetter> getAllExperienceLetterRequest();
  boolean addExperienceLetterRequest(RequestExperienceLetter requestExperienceLetter);
  boolean updateExperienceLetterRequest(RequestExperienceLetter requestExperienceLetter, Integer id);
}
