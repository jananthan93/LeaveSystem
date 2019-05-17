package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.Location;
import com.sgic.hrm.commons.repository.LocationRepository;
import com.sgic.hrm.profile.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
  @Autowired
  private LocationRepository locationRepository;

  @Override
  public boolean addLocation(Location location) {
    locationRepository.save(location);
    return true;
  }

  @Override
  public List<Location> getLocation() {
    return locationRepository.findAll();
  }

  @Override
  public boolean editLocation(Location location, Integer id) {
    if (locationRepository.getOne(id) != null) {
      location.setId(id);
      locationRepository.save(location);
      return true;
    }
    return false;
  }

  @Override
  public Optional<Location> getLocationId(Integer id) {
    return locationRepository.findById(id);
  }

  @Override
  public boolean deleteLocation(Integer id) {
    if (locationRepository.getOne(id) != null) {

      locationRepository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public Location findByLocationId(Integer id) {
    return locationRepository.findLocationById(id);
  }

}
