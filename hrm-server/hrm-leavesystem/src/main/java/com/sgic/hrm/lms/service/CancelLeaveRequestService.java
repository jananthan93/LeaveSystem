package com.sgic.hrm.lms.service;

import java.util.List;
import com.sgic.hrm.commons.dto.AcceptCancelRequestDto;
import com.sgic.hrm.commons.dto.RejectCancelRequestDto;
import com.sgic.hrm.commons.entity.CancelLeaveRequest;

public interface CancelLeaveRequestService {

  boolean addCancelLeaveRequest(CancelLeaveRequest cancelLeaveRequest);
  
  boolean deleteCancelLeaveRequest(Integer id);
  
  boolean acceptCancelLeaveRequest(AcceptCancelRequestDto acceptCancelRequestDto);
  
  boolean rejectCancelLeaveRequest(RejectCancelRequestDto rejectCancelRequestDto);
  
  List<CancelLeaveRequest> getAllCancelRequest();
  
  List<CancelLeaveRequest> getPendingCancelRequest();
  
  List<CancelLeaveRequest> getCancelRequestByUser(Integer userId);
}
