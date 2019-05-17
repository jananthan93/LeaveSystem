package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.Designation;
import com.sgic.hrm.commons.repository.DesignationRepository;
import com.sgic.hrm.profile.service.DesignationService;


@Service
public class DesignationServiceImpl implements DesignationService {
  @Autowired
  private DesignationRepository designationRepository;

  @Override
  public boolean addDesignation(Designation designation) {
    designationRepository.save(designation);
    return true;
  }

  @Override
  public List<Designation> getDesignation() {

    return designationRepository.findAll();
  }

  @Override
  public Designation findByDesignationId(Integer id) {
    return designationRepository.findDesignationById(id);
  }

  @Override
  public boolean editDesignation(Designation designation, Integer id) {
    if (designationRepository.getOne(id) != null) {
      designation.setId(id);
      designationRepository.save(designation);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteDesignation(Integer id) {
    if (designationRepository.getOne(id) != null) {
      designationRepository.deleteById(id);
      return true;
    }
    return false;
  }

}
