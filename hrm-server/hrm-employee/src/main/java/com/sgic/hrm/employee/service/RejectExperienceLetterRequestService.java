package com.sgic.hrm.employee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.RejectExperienceLetterRequest;

public interface RejectExperienceLetterRequestService {
  public List<RejectExperienceLetterRequest> getRejectExperienceLetterRequest();

  public void createRejectExperienceLetterRequest(RejectExperienceLetterRequest rejectExperienceLetterRequest);

  boolean updateRejectExperienceLetterRequest(RejectExperienceLetterRequest rejectExperienceLetterRequest, Integer id);

  public void deleteRejectExperienceLetterRequest(Integer id);
}
