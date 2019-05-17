package com.sgic.hrm.profile.service;

import java.util.List;
import com.sgic.hrm.commons.entity.Designation;

public interface DesignationService {

  boolean addDesignation(Designation designation);

  List<Designation> getDesignation();

  boolean editDesignation(Designation designation, Integer id);

  boolean deleteDesignation(Integer id);

  Designation findByDesignationId(Integer id);

}
