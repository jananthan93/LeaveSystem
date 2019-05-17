package com.sgic.hrm.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.entity.ExperienceLetter;
import com.sgic.hrm.employee.service.ExperienceLetterService;

@RestController
@RequestMapping("/experience-letter")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3200)
public class ExperienceLetterController {

  @Autowired
  private ExperienceLetterService experienceLetterService;

  @GetMapping
  public List<ExperienceLetter> getGenerateLetter() {
    return experienceLetterService.getExperienceLetter();
  }

  @PostMapping
  public void postRejectReason(@RequestBody ExperienceLetter generateLetter) {
    experienceLetterService.createExperienceLetter(generateLetter);
  }

  @PutMapping("/{id}")
  public void editGenerateLetter(@RequestBody ExperienceLetter experienceLetter,
      @PathVariable Integer id) {
    experienceLetterService.updateExperienceLetter(experienceLetter, id);
  }
  
}
