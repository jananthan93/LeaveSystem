package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.hrm.commons.entity.HolidayCalendar;
import com.sgic.hrm.commons.repository.HolidayCalendarRepository;
import com.sgic.hrm.lms.service.HolidayCalendarService;
import com.sgic.hrm.lms.service.LoginService;
import com.sgic.hrm.lms.service.ResizableService;

@Service
public class HolidayCalendarServiceImpl implements HolidayCalendarService {

  @Autowired
  HolidayCalendarRepository holidayCalendarRepository;
  @Autowired
  LoginService loginService;
  @Autowired
  ResizableService resizableService;

  @Transactional
  @Override
  public boolean createHoliday(HolidayCalendar holidayCalendar, String username) {

    if (holidayCalendar != null) {
      holidayCalendar.setResizable(resizableService.findByStartAndEnd(
          holidayCalendar.getResizable().isBeforeStart(),
          holidayCalendar.getResizable().isAfterEnd()));
      holidayCalendar.setEnteredBy(loginService.getUser(username));
      holidayCalendarRepository.save(holidayCalendar);
      return true;
    }
    return false;
  }

  @Override
  public List<HolidayCalendar> viewAllHoliday() {
    return holidayCalendarRepository.findAll();
  }

  @Transactional
  @Override
  public boolean updateHoliday(Integer id, HolidayCalendar holidayCalendar, String username) {
    if (holidayCalendarRepository.getOne(id) != null) {    	
      holidayCalendar.setId(id);
      holidayCalendar.setEnteredBy(loginService.getUser(username));
      holidayCalendarRepository.save(holidayCalendar);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteholiday(Integer id) {
    if (holidayCalendarRepository.getOne(id) != null) {
      holidayCalendarRepository.deleteById(id);
      return true;
    }
    return false;
  }

}
