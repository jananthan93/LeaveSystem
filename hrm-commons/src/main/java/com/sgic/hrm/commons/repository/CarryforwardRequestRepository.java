package com.sgic.hrm.commons.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.hrm.commons.entity.CarryforwardRequest;
import com.sgic.hrm.commons.entity.User;
import com.sgic.hrm.commons.enums.Status;

public interface CarryforwardRequestRepository extends JpaRepository<CarryforwardRequest, Integer> {
	CarryforwardRequest findByUser(User user);
	List<CarryforwardRequest> findByStatusOrderById(Status status);
	
	public List<CarryforwardRequest> findByUserNotAndStatusOrderByIdDesc(User user,Status status);
	
}
