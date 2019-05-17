package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.Job;
import com.sgic.hrm.commons.repository.JobRepository;
import com.sgic.hrm.profile.service.JobService;

@Service
public class JobServiceImpl implements JobService {
  @Autowired
  private JobRepository jobRepository;

  @Override
  public boolean addJob(Job job) {
    jobRepository.save(job);
    return true;
  }

  @Override
  public List<Job> getJob() {
    return jobRepository.findAll();
  }

  @Override
  public boolean editJob(Job job, Integer id) {
    if (jobRepository.getOne(id) != null) {
      job.setId(id);
      jobRepository.save(job);
      return true;
    }
    return false;
  }

  @Override
  public Optional<Job> getJobId(Integer id) {
    return jobRepository.findById(id);

  }

  @Override
  public boolean deleteJob(Integer id) {
    if (jobRepository.getOne(id) != null) {
      jobRepository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public Job findByJobId(Integer id) {
    // TODO Auto-generated method stub
    return jobRepository.findJobById(id);

  }
}
