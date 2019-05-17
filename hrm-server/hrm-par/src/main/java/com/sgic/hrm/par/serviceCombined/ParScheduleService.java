package com.sgic.hrm.par.serviceCombined;

import com.sgic.hrm.commons.dto.par.ScheduleParDtoGet;
import com.sgic.hrm.commons.dto.par.ScheduleParDtoPost;



public interface ParScheduleService {

	/*
	 create entity in par
	 	par id
	 	emp id
	 	date
	 	time
	 save list of appraisors at parAppraisors table
	 	array of
	 	[par id
	 	apprasor id]
	 save list of par content
	 	array of
	 	[par id
	 	content id]
	 */
	
	public void createSchedulePar(ScheduleParDtoPost objScheduleParDTO);
	// get schedule par
	
	public ScheduleParDtoGet getSchedulePar(Integer parId);

	public void deleteSchedulePar(Integer parId);
		
		//add par content 
		// remove par content
		
		// add par appraisor
		
		// delete schedule par
}