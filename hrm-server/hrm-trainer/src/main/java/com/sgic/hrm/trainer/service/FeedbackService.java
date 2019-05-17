//code done by ragulan
package com.sgic.hrm.trainer.service;

import java.util.List;
import com.sgic.hrm.commons.entity.trainer.Feedback;

public interface FeedbackService {
  public List<Feedback> getFeedback();

  public boolean createFeedback(Feedback feedback);

  public List<Feedback> getTraineeByTraineeId(Integer id);
  // public List<Feedback> getTrainerByTrainerId(Integer id);
  // List<Feedback> getTrainerByName(String username);
}
