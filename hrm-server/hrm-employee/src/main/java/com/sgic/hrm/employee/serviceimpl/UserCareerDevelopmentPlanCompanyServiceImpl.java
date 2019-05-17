package com.sgic.hrm.employee.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.UserCareerDevelopmentPlanCompany;
import com.sgic.hrm.commons.repository.UserCareerDevelopmentPlanCompanyRepository;
import com.sgic.hrm.employee.service.UserCareerDevelopmentPlanCompanyService;

@Service
public class UserCareerDevelopmentPlanCompanyServiceImpl implements UserCareerDevelopmentPlanCompanyService{

  @Autowired
  UserCareerDevelopmentPlanCompanyRepository userCareerDevelopmentPlanCompanyRepository;
  @Override
  public boolean addUserCareerDevelopmentPlanCompany(
      UserCareerDevelopmentPlanCompany careerDevelopmentPlanCompany) {
    userCareerDevelopmentPlanCompanyRepository.save(careerDevelopmentPlanCompany);
    return true;
  }

  @Override
  public List<UserCareerDevelopmentPlanCompany> getUserCareerDevelopmentPlanCompany() {
    return userCareerDevelopmentPlanCompanyRepository.findAll();
  }

  @Override
  public boolean editCareerDevelopmentPlanCompany(
      UserCareerDevelopmentPlanCompany careerDevelopmentPlanCompany, Integer id) {
    boolean success = false;
    if (userCareerDevelopmentPlanCompanyRepository.getOne(id) != null) {
      careerDevelopmentPlanCompany.setId(id);
      userCareerDevelopmentPlanCompanyRepository.save(careerDevelopmentPlanCompany);
      success = true;
      return success;
    }
    return success;
  }

  @Override
  public boolean deleteUserCareerDevelopmentPlanCompany(Integer id) {
    if (userCareerDevelopmentPlanCompanyRepository.getOne(id) != null) {
      userCareerDevelopmentPlanCompanyRepository.deleteById(id);
      return true;
  }
  return false;
  }

  @Override
  public UserCareerDevelopmentPlanCompany getUserCareerDevelopmentPlanCompanyById(int id) {
    return userCareerDevelopmentPlanCompanyRepository.getOne(id);
  }

  @Override
  public List<UserCareerDevelopmentPlanCompany> getUserCareerDevelopmentPlanByUserId(int id) {
    return userCareerDevelopmentPlanCompanyRepository.findById(id);
  }
}
