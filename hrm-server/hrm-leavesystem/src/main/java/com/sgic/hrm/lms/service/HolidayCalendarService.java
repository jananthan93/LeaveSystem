package com.sgic.hrm.lms.service;

import java.util.List;

import com.sgic.hrm.commons.entity.HolidayCalendar;

public interface HolidayCalendarService {
	
	boolean createHoliday(HolidayCalendar holidayCalendar, String username);
	List<HolidayCalendar> viewAllHoliday();
	boolean updateHoliday(Integer id,HolidayCalendar holidayCalendar, String username);
	boolean deleteholiday(Integer id);

}
