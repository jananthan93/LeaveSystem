package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.ProfessionalMembership;
import com.sgic.hrm.commons.entity.User;
import com.sgic.hrm.commons.repository.ProfessionalMembershipRepository;
import com.sgic.hrm.commons.repository.UserRepository;
import com.sgic.hrm.profile.service.ProfessionalMembershipService;


@Service
public class ProfessionalMembershipServiceImpl implements ProfessionalMembershipService {
  @Autowired
  private ProfessionalMembershipRepository professionalMembershipRepository;
  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean addProfessionalMembership(ProfessionalMembership professionalMembership,
      User user) {
    professionalMembership.setUser(user);
    professionalMembershipRepository.save(professionalMembership);
    return true;
  }

  @Override
  public List<ProfessionalMembership> getAllProfessionalMembership() {
    return professionalMembershipRepository.findAll();
  }

  @Override
  public boolean editProfessionalMembership(ProfessionalMembership professionalMembership,
      User user, Integer id) {
    if (professionalMembershipRepository.getOne(id) != null) {
      professionalMembership.setId(id);
      professionalMembership.setUser(user);
      professionalMembershipRepository.save(professionalMembership);
      return true;
    }
    return false;
  }

  @Override
  public Optional<ProfessionalMembership> getProfessionalMembershipById(int id) {
    return professionalMembershipRepository.findById(id);
  }

  @Override
  public boolean deleteProfessionalMembership(Integer id) {
    if (professionalMembershipRepository.getOne(id) != null) {
      professionalMembershipRepository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public List<ProfessionalMembership> getProfessionalMembershipByUserId(Integer uid) {
    return professionalMembershipRepository.findByUser(userRepository.findUserById(uid));
  }

}
