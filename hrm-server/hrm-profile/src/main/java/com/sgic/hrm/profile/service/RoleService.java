package com.sgic.hrm.profile.service;

import java.util.List;
import com.sgic.hrm.commons.entity.Role;

public interface RoleService {
  List<Role> getRoles();

  Role findByRoleId(Long id);
}
