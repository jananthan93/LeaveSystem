//code done by ragulan
package com.sgic.hrm.trainer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.trainer.dto.FeedbackDto;
import com.sgic.hrm.commons.trainer.dto.FeedbackSaveDto;
import com.sgic.hrm.commons.trainer.dto.mapper.FeedbackDtoMapper;
import com.sgic.hrm.commons.trainer.entity.mapper.FeedbackMapper;
import com.sgic.hrm.trainer.service.FeedbackService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3200)
@RestController
public class FeedbackController {
  @Autowired
  private FeedbackService feedbackService;

  @GetMapping("/feedback")
  public ResponseEntity<List<FeedbackDto>> getAllFeedback() {
    return new ResponseEntity<>(
        FeedbackMapper.mapFeedbackListToFeedbackDtoList(feedbackService.getFeedback()),
        HttpStatus.OK);
  }

  @PostMapping("/feedback")
  public HttpStatus addFeedback(@RequestBody FeedbackSaveDto feedbackSaveDto) {
    boolean test = feedbackService
        .createFeedback(FeedbackDtoMapper.mapFeedbackSaveDtoToFeedback(feedbackSaveDto));
    if (test) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  // @GetMapping("/trainer/{username}")
  // public ResponseEntity<List<FeedbackDto>> getTrainersFeedbackByUsername(@PathVariable String
  // username){
  // return new
  // ResponseEntity<>(FeedbackMapper.mapFeedbackListToFeedbackDtoList(feedbackService.getTrainerByUsername(username)),
  // HttpStatus.OK);
  // }
}
