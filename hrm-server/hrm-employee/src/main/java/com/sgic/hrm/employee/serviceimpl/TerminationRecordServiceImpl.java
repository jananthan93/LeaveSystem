package com.sgic.hrm.employee.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.TerminationRecord;
import com.sgic.hrm.commons.repository.TerminationRecordRepository;
import com.sgic.hrm.employee.service.TerminationRecordService;

@Service
public class TerminationRecordServiceImpl implements TerminationRecordService {
  @Autowired
  TerminationRecordRepository terminationRecordRepository;

  @Override
  public boolean addTerminationRecord(TerminationRecord terminationRecord) {
    terminationRecordRepository.save(terminationRecord);
    return true;
  }

  @Override
  public List<TerminationRecord> getAllTerminationRecord() {

    return terminationRecordRepository.findAll();
  }

  @Override
  public boolean editTerminationRecord(TerminationRecord terminationRecord, Integer id) {
    if (terminationRecordRepository.getOne(id) != null) {
      terminationRecord.setId(id);
      terminationRecordRepository.save(terminationRecord);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteTerminationRecord(Integer id) {
    terminationRecordRepository.deleteById(id);
    return true;
  }

  @Override
  public TerminationRecord getById(Integer id) {
    return terminationRecordRepository.findById(id).orElse(null);
  }


}
