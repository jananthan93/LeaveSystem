package com.sgic.hrm.employee.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.RejectExperienceLetterRequest;
import com.sgic.hrm.commons.repository.RejectExperienceLetterRequestRepository;
import com.sgic.hrm.employee.service.RejectExperienceLetterRequestService;

@Service
public class RejectExperienceLetterRequestImpl implements RejectExperienceLetterRequestService {

  @Autowired
  private RejectExperienceLetterRequestRepository rejectExperienceLetterRequestRepository;

  @Override
  public List<RejectExperienceLetterRequest> getRejectExperienceLetterRequest() {
    return rejectExperienceLetterRequestRepository.findAll();
  }
  
  @Override
  public void createRejectExperienceLetterRequest(
      RejectExperienceLetterRequest rejectExperienceLetterRequest) {
    rejectExperienceLetterRequestRepository.save(rejectExperienceLetterRequest);
  }

  @Override
  public boolean updateRejectExperienceLetterRequest(
      RejectExperienceLetterRequest rejectExperienceLetterRequest, Integer id) {
    if (rejectExperienceLetterRequestRepository.getOne(id) != null) {
      rejectExperienceLetterRequest.setId(id);
      rejectExperienceLetterRequestRepository.save(rejectExperienceLetterRequest);
      return true;
    }
    return false;
  }

  @Override
  public void deleteRejectExperienceLetterRequest(Integer id) {
    rejectExperienceLetterRequestRepository.deleteById(id);
  }


}
