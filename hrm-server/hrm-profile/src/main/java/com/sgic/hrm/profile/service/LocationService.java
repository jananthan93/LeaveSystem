package com.sgic.hrm.profile.service;

import java.util.List;
import java.util.Optional;
import com.sgic.hrm.commons.entity.Location;



public interface LocationService {
  boolean addLocation(Location location);

  List<Location> getLocation();

  boolean editLocation(Location location, Integer id);

  Optional<Location> getLocationId(Integer id);

  boolean deleteLocation(Integer id);

  Location findByLocationId(Integer id);
}
