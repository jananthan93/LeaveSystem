package com.sgic.hrm.commons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgic.hrm.commons.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{
	
  Optional<Login> findByUsername(String username);
  Boolean existsByUsername(String username); 
  Boolean existsByEmail(String email);
  @Query("SELECT lg FROM Login lg WHERE lg.user.id=?1")
  Optional<Login> findUserById(Integer id);
 
}
