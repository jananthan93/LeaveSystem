package com.sgic.hrm.profile.service;

import java.util.List;
import com.sgic.hrm.commons.entity.ExamType;

public interface ExamTypeService {
  boolean addExamType(ExamType examtype);

  List<ExamType> getAllExamType();

  ExamType findByExamTypeId(Integer id);

  boolean editExamType(ExamType examtype, Integer id);

  boolean deleteExamType(Integer id);
}
