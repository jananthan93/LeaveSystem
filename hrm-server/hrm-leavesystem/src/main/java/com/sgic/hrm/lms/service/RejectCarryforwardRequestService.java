package com.sgic.hrm.lms.service;

import java.util.List;
import com.sgic.hrm.commons.entity.RejectCarryforwardRequest;

public interface RejectCarryforwardRequestService {

  boolean addRejectCarryforwardRequest(RejectCarryforwardRequest rejectCarryforwardRequest);

  boolean editRejectCarryforwardRequest(Integer id,
      RejectCarryforwardRequest rejectCarryforwardRequest);

  List<RejectCarryforwardRequest> getAllRejectCarryforwardRequest();

  RejectCarryforwardRequest getRejectCarryforwardRequest(Integer id);

  boolean deleteRejectCarryforwardRequest(Integer id);

  RejectCarryforwardRequest getRejectCarryforwardRequestByUser(String userName);
}
