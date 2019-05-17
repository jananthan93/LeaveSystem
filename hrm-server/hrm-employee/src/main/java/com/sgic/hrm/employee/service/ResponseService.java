package com.sgic.hrm.employee.service;

import java.util.List;
import com.sgic.hrm.commons.entity.Response;

public interface ResponseService {

	List<Response> viewResponse();
	
	boolean addResponse(Response response);

	List<Response> getSpecificUser(String name);

}
