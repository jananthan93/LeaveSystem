package com.sgic.hrm.employee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.UserCareerDevelopmentPlanSelf;

public interface UserCareerDevelopmentPlanSelfService {


  boolean addCareerDevelopmentPlanSelf(UserCareerDevelopmentPlanSelf userCareerDevelopmentPlanSelf);

  List<UserCareerDevelopmentPlanSelf> getCareerDevelopmentPlanSelf();

  boolean editCareerDevelopmentPlanSelf(UserCareerDevelopmentPlanSelf userCareerDevelopmentPlanSelf, Integer id);

  boolean deleteCareerDevelopmentPlanSelf(Integer id);

  UserCareerDevelopmentPlanSelf getCareerDevelopmentPlanSelfById(Integer id);
  
  List<UserCareerDevelopmentPlanSelf> getCareerDevelopmentPlanSelfByUserId(int id);
  
}
