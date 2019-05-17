package com.sgic.hrm.profile.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.entity.LogInCrediential;
import com.sgic.hrm.profile.service.LogInCredientialService;

@RestController
public class LogInCredientialController {
  @Autowired
  private LogInCredientialService logInCredientialService;

  @PostMapping("/logInCrediential")
  public HttpStatus addLogInCrediential(@Valid @RequestBody LogInCrediential logInCrediential) {
    boolean test = logInCredientialService.addLogInCrediential(logInCrediential);
    if (test) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @GetMapping("/logInCrediential")
  public ResponseEntity<List<LogInCrediential>> getLogInCrediential() {
    return new ResponseEntity<>(logInCredientialService.getAllLogInCrediential(), HttpStatus.OK);
  }
}
