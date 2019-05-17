package com.sgic.hrm.commons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgic.hrm.commons.entity.Role;
import com.sgic.hrm.commons.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	 Optional<Role> findByName(RoleName roleName);
	 Role findRoleById(Long id);
}
