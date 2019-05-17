package com.sgic.hrm.profile.service;

import java.util.List;
import java.util.Optional;
import com.sgic.hrm.commons.entity.Job;
import com.sgic.hrm.commons.entity.KeyActivity;
import com.sgic.hrm.commons.entity.Location;
import com.sgic.hrm.commons.entity.RolesAndResponsibilites;
import com.sgic.hrm.commons.entity.User;

public interface RolesAndResponsibilitiesService {
  boolean addRolesAndResponsibilites(RolesAndResponsibilites rolesAndResponsibilites, Job job,
      User userObj, KeyActivity keyActivity, Location location);

  List<RolesAndResponsibilites> getRolesAndResponsibilites();

  boolean editRolesAndResponsibilites(RolesAndResponsibilites rolesAndResponsibilites, User userObj,
      Job job, Location location, KeyActivity keyActivity, Integer id);

  Optional<RolesAndResponsibilites> getReloAndResponsibilities(Integer id);

  boolean deleteRolesAndResponsibilites(Integer id);

  List<RolesAndResponsibilites> getRolesAndResponsibilitesByUserId(Integer uid);
}
