//code done by jayapriya
package com.sgic.hrm.trainer.service;

import java.util.List;

import com.sgic.hrm.commons.entity.trainer.PreRequest;

public interface PreRequestService {
	
	boolean addPreRequest(PreRequest preRequest);
	
	boolean editPreRequest(Integer id,PreRequest preRequest);
	
	boolean deletePreRequest(Integer id);
	
	List<PreRequest> getAllPreRequest();
	
	PreRequest getPreRequestById(Integer id);
	
	
	

}
