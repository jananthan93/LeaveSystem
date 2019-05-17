package com.sgic.hrm.lms.service;

import java.util.List;
import com.sgic.hrm.commons.entity.AcceptCarryforwardRequest;

public interface AcceptCarryforwardRequestService {

  boolean addAcceptCarryforwardRequest(AcceptCarryforwardRequest acceptCarryforwardRequest);

  boolean editAcceptCarryforwardRequest(Integer id,
      AcceptCarryforwardRequest acceptCarryforwardRequest);

  List<AcceptCarryforwardRequest> getAllAcceptCarryforwardRequests();

  AcceptCarryforwardRequest getAcceptCarryforwardRequest(Integer id);

  boolean deleteAcceptCarryforwardRequest(Integer id);


}
