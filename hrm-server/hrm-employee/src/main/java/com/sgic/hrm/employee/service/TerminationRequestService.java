package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.TerminationRequest;


public interface TerminationRequestService {

  boolean addTerminationRequest(TerminationRequest terminationRequest);

  List<TerminationRequest> getAllTerminationRequest();

  boolean editTerminationRequest(TerminationRequest terminationRequest, Integer id);

  boolean deleteTerminationRequest(Integer id);

  List<TerminationRequest> getPendingTerminationRequest();

}
