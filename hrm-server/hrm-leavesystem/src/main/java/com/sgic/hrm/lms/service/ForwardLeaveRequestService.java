package com.sgic.hrm.lms.service;

import java.util.List;
import com.sgic.hrm.commons.entity.ForwardLeaveRequest;
import com.sgic.hrm.commons.entity.LeaveRequest;

public interface ForwardLeaveRequestService {

  boolean addForwardToList(List<ForwardLeaveRequest> list);

  List<ForwardLeaveRequest> getForwardToList(LeaveRequest leaveRequest);
}
