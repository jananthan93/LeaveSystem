package com.sgic.hrm.lms.service;

import java.util.List;
import com.sgic.hrm.commons.entity.AcceptCancelRequest;

public interface AcceptCancelRequestService {

  boolean addAcceptCancelRequest(AcceptCancelRequest acceptCancelRequest);

  boolean editAcceptCancelRequest(Integer id, AcceptCancelRequest acceptCancelRequest);

  List<AcceptCancelRequest> getAllAcceptCancelRequests();

  AcceptCancelRequest getAcceptCancelRequest(Integer id);

  boolean deleteAcceptCancelRequest(Integer id);


}
