package com.sgic.hrm.profile.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.entity.KeyActivity;
import com.sgic.hrm.profile.service.KeyActivityService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class KeyActivityController {
  @Autowired
  private KeyActivityService keyActivityService;

  @PostMapping("/keyactivity")
  public HttpStatus addKeyActivity(@RequestBody KeyActivity keyActivity) {
    if (keyActivityService.addKeyActivity(keyActivity)) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @GetMapping("/keyactivity")
  public ResponseEntity<List<KeyActivity>> getKeyActivity() {
    return new ResponseEntity<>(keyActivityService.getKeyActivity(), HttpStatus.OK);
  }

  @PutMapping("/keyactivity/{id}")
  public HttpStatus modifyKeyActivity(@RequestBody KeyActivity keyActivity,
      @PathVariable Integer id) {
    if (keyActivityService.editKeyActivity(keyActivity, id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @DeleteMapping("/keyactivity/{id}")
  public HttpStatus deleteKeyActivity(@PathVariable Integer id) {
    if (keyActivityService.deleteKeyActivity(id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }
}
