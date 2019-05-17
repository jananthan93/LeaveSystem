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
import com.sgic.hrm.commons.entity.Location;
import com.sgic.hrm.profile.service.LocationService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class LocationController {
  @Autowired
  private LocationService locationService;

  @PostMapping("/location")
  public HttpStatus addLocation(@RequestBody Location location) {
    if (locationService.addLocation(location)) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @GetMapping("/location")
  public ResponseEntity<List<Location>> getLocation() {
    return new ResponseEntity<>(locationService.getLocation(), HttpStatus.OK);
  }

  @PutMapping("location/{id}")
  public HttpStatus modifyLocation(@PathVariable Integer id, @RequestBody Location location) {
    if (locationService.editLocation(location, id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @DeleteMapping("location/{id}")
  public HttpStatus deleteLocation(@PathVariable Integer id) {
    if (locationService.deleteLocation(id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

}
