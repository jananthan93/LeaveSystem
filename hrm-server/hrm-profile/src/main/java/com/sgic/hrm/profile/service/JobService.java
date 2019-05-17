package com.sgic.hrm.profile.service;

import java.util.List;
import java.util.Optional;
import com.sgic.hrm.commons.entity.Job;

public interface JobService {
  boolean addJob(Job job);

  List<Job> getJob();

  boolean editJob(Job job, Integer id);

  Optional<Job> getJobId(Integer id);

  boolean deleteJob(Integer id);

  Job findByJobId(Integer id);
}
