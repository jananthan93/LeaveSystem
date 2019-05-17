package com.sgic.hrm.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.commons.entity.Resizable;

public interface ResizableRepository extends JpaRepository<Resizable, Integer>{

  Resizable findByBeforeStartAndAfterEnd(boolean beforeStart , boolean afterEnd);
}
