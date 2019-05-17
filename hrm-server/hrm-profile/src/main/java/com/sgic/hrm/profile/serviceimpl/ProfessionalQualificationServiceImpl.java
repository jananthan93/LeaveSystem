package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.ProfessionalQualification;
import com.sgic.hrm.commons.entity.User;
import com.sgic.hrm.commons.repository.ProfessionalQualificationRepository;
import com.sgic.hrm.commons.repository.UserRepository;
import com.sgic.hrm.profile.service.ProfessionalQualificationService;


@Service
public class ProfessionalQualificationServiceImpl implements ProfessionalQualificationService {

  @Autowired
  private ProfessionalQualificationRepository professionalQualificationRepository;
  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean addProfessionalQualification(ProfessionalQualification professionalQualification,
      User user) {
    professionalQualification.setUser(user);
    professionalQualificationRepository.save(professionalQualification);
    return true;

  }

  @Override
  public List<ProfessionalQualification> getAllProfessionalQualifications() {

    return professionalQualificationRepository.findAll();
  }

  @Override
  public boolean editProfessionalQualification(ProfessionalQualification professionalQualification,
      User user, Integer id) {
    if (professionalQualificationRepository.getOne(id) != null) {
      professionalQualification.setId(id);
      professionalQualification.setUser(user);
      professionalQualificationRepository.save(professionalQualification);
      return true;
    }
    return false;
  }

  @Override
  public Optional<ProfessionalQualification> getProfessionalQualificationById(int id) {
    return professionalQualificationRepository.findById(id);
  }

  @Override
  public boolean deleteProfessionalQualification(Integer id) {
    if (professionalQualificationRepository.getOne(id) != null) {
      professionalQualificationRepository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public List<ProfessionalQualification> getProfessionalQualificationByUserId(Integer uid) {
    return professionalQualificationRepository
        .findProfessionalQualificationByUser(userRepository.findUserById(uid));
  }
}
