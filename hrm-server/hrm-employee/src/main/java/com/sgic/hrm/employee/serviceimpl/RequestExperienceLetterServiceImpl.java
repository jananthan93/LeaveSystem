package com.sgic.hrm.employee.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.RequestExperienceLetter;
import com.sgic.hrm.commons.repository.RequestExperienceLetterRepository;
import com.sgic.hrm.employee.service.RequestExperienceLetterService;

@Service
public class RequestExperienceLetterServiceImpl implements RequestExperienceLetterService {

  @Autowired
  private RequestExperienceLetterRepository requestExperienceLetterRepository;

  @Override
  public List<RequestExperienceLetter> getAllExperienceLetterRequest() {
    return requestExperienceLetterRepository.findAll();
  }

  @Override
  public boolean addExperienceLetterRequest(RequestExperienceLetter requestExperienceLetter) {
    if (requestExperienceLetter != null) {
      requestExperienceLetterRepository.save(requestExperienceLetter);
      return true;
    }
    return false;
  }

  @Override
  public boolean updateExperienceLetterRequest(RequestExperienceLetter requestExperienceLetter,
      Integer id) {
    if (requestExperienceLetterRepository.getOne(id) != null) {
      requestExperienceLetter.setId(id);
      requestExperienceLetterRepository.save(requestExperienceLetter);
      return true;
    }
    return false;
  }

}
