package com.sgic.hrm.employee.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.UserCareerDevelopmentPlanSelf;
import com.sgic.hrm.commons.repository.UserCareerDevelopmentPlanSelfRepository;
import com.sgic.hrm.employee.service.UserCareerDevelopmentPlanSelfService;

@Service
public class UserCareerDevelopmentPlanSelfServiceImpl implements UserCareerDevelopmentPlanSelfService{


  @Autowired
  UserCareerDevelopmentPlanSelfRepository userCareerDevelopmentPlanSelfRepository;

  @Override
  public boolean addCareerDevelopmentPlanSelf(
      UserCareerDevelopmentPlanSelf userCareerDevelopmentPlanSelf) {
    userCareerDevelopmentPlanSelfRepository.save(userCareerDevelopmentPlanSelf);
    return true;
  }

  @Override
  public List<UserCareerDevelopmentPlanSelf> getCareerDevelopmentPlanSelf() {
    return userCareerDevelopmentPlanSelfRepository.findAll();
    
  }

  @Override
  public boolean editCareerDevelopmentPlanSelf(
      UserCareerDevelopmentPlanSelf userCareerDevelopmentPlanSelf, Integer id) {
    boolean success = false;
    if (userCareerDevelopmentPlanSelfRepository.getOne(id) != null) {
      userCareerDevelopmentPlanSelf.setId(id);
      userCareerDevelopmentPlanSelfRepository.save(userCareerDevelopmentPlanSelf);
      success = true;
      return success;
    }
    return success;
  }

  @Override
  public boolean deleteCareerDevelopmentPlanSelf(Integer id) {
    if (userCareerDevelopmentPlanSelfRepository.getOne(id) != null) {
      userCareerDevelopmentPlanSelfRepository.deleteById(id);
      return true;
  }
  return false;
  }
  
  @Override
  public UserCareerDevelopmentPlanSelf getCareerDevelopmentPlanSelfById(Integer id) {
    return userCareerDevelopmentPlanSelfRepository.getOne(id);
  }

  @Override
  public List<UserCareerDevelopmentPlanSelf> getCareerDevelopmentPlanSelfByUserId(int id) {
    return userCareerDevelopmentPlanSelfRepository.findById(id);
  }

}
