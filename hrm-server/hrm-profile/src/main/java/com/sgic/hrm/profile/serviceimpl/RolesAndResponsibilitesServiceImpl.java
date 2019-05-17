package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.Job;
import com.sgic.hrm.commons.entity.KeyActivity;
import com.sgic.hrm.commons.entity.Location;
import com.sgic.hrm.commons.entity.RolesAndResponsibilites;
import com.sgic.hrm.commons.entity.User;
import com.sgic.hrm.commons.repository.RolesAndResponsibilityRepository;
import com.sgic.hrm.commons.repository.UserRepository;
import com.sgic.hrm.profile.service.RolesAndResponsibilitiesService;

@Service
public class RolesAndResponsibilitesServiceImpl implements RolesAndResponsibilitiesService {
  @Autowired
  private RolesAndResponsibilityRepository rolesAndResponsibilitesRepository;
  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean addRolesAndResponsibilites(RolesAndResponsibilites rolesAndResponsibilites,
      Job job, User user, KeyActivity keyActivity, Location location) {
    rolesAndResponsibilites.setUser(user);
    rolesAndResponsibilites.setJob(job);
    rolesAndResponsibilites.setKeyActivity(keyActivity);
    rolesAndResponsibilites.setLocation(location);
    rolesAndResponsibilitesRepository.save(rolesAndResponsibilites);
    return true;
  }

  @Override
  public List<RolesAndResponsibilites> getRolesAndResponsibilites() {
    return rolesAndResponsibilitesRepository.findAll();
  }

  @Override
  public boolean editRolesAndResponsibilites(RolesAndResponsibilites rolesAndResponsibilites,
      User user, Job job, Location location, KeyActivity keyActivity, Integer id) {
    if (rolesAndResponsibilitesRepository.getOne(id) != null) {
      rolesAndResponsibilites.setId(id);
      rolesAndResponsibilites.setUser(user);
      rolesAndResponsibilites.setJob(job);
      rolesAndResponsibilites.setLocation(location);
      rolesAndResponsibilites.setKeyActivity(keyActivity);
      rolesAndResponsibilitesRepository.save(rolesAndResponsibilites);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteRolesAndResponsibilites(Integer id) {
    if (rolesAndResponsibilitesRepository.getOne(id) != null) {

      rolesAndResponsibilitesRepository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public Optional<RolesAndResponsibilites> getReloAndResponsibilities(Integer id) {
    return rolesAndResponsibilitesRepository.findById(id);
  }

  @Override
  public List<RolesAndResponsibilites> getRolesAndResponsibilitesByUserId(Integer uid) {
    return rolesAndResponsibilitesRepository
        .findRolesAndResponsibilitesByUser(userRepository.findUserById(uid));
  }

}
