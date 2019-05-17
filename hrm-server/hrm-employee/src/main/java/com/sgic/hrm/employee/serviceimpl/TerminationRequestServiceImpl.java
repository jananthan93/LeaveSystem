package com.sgic.hrm.employee.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.TerminationRequest;
import com.sgic.hrm.commons.enums.Status;
import com.sgic.hrm.commons.repository.TerminationRequestRepository;
import com.sgic.hrm.employee.service.TerminationRequestService;


@Service
public class TerminationRequestServiceImpl implements TerminationRequestService {

  @Autowired
  TerminationRequestRepository terminationRequestRepository;

  @Override
  public boolean addTerminationRequest(TerminationRequest terminationRequest) {
	  terminationRequest.setStatus(Status.PENDING);
    terminationRequestRepository.save(terminationRequest);
    return true;
  }

  @Override
  public List<TerminationRequest> getAllTerminationRequest() {
    return terminationRequestRepository.findAll();
  }

  @Override
  public boolean editTerminationRequest(TerminationRequest terminationRequest, Integer id) {
    if (terminationRequestRepository.getOne(id) != null) {
      terminationRequest.setId(id);
      terminationRequestRepository.save(terminationRequest);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteTerminationRequest(Integer id) {
    terminationRequestRepository.deleteById(id);
    return true;
  }

  @Override
  public List<TerminationRequest> getPendingTerminationRequest() {
    return terminationRequestRepository.findByStatus(Status.PENDING);
  }

}
