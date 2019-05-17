package com.sgic.hrm.commons.repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.commons.entity.Colors;

public interface ColorsRepository  extends JpaRepository<Colors, Entity>{

}
