package com.sgic.hrm.trainer.service;

//done by_Sujaany
import java.util.List;

import com.sgic.hrm.commons.entity.trainer.RecordOfEmployment;

public interface RecordOfEmploymentService {
	List<RecordOfEmployment> getAllRecordOfEmployment();

	boolean createRecordOfEmployment(RecordOfEmployment recordOfEmployment);

	boolean deleteRecordOfEmployment(Integer id);

	boolean updateRecordOfEmployment(RecordOfEmployment recordOfEmployment, Integer id);

	RecordOfEmployment getById(Integer id);
}
