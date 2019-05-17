package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.ExamType;
import com.sgic.hrm.commons.repository.ExamTypeRepository;
import com.sgic.hrm.profile.service.ExamTypeService;


@Service
public class ExamTypeServiceImpl implements ExamTypeService {
  @Autowired
  private ExamTypeRepository examTypeRepository;

  @Override
  public boolean addExamType(ExamType examtype) {
    examTypeRepository.save(examtype);
    return true;
  }

  @Override
  public List<ExamType> getAllExamType() {
    return examTypeRepository.findAll();
  }

  @Override
  public ExamType findByExamTypeId(Integer id) {
    return examTypeRepository.findExamTypeById(id);
  }

  @Override
  public boolean editExamType(ExamType examtype, Integer id) {
    if (examTypeRepository.getOne(id) != null) {
      examtype.setId(id);
      examTypeRepository.save(examtype);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteExamType(Integer id) {
    if (examTypeRepository.getOne(id) != null) {
      examTypeRepository.deleteById(id);
    }
    return false;
  }

}
