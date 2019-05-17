package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sgic.hrm.commons.dto.HolidayCalendarData;
import com.sgic.hrm.commons.entity.HolidayCalendar;

public class HolidayCalendarToHolidayCalendarData {

  public static HolidayCalendarData mapToHolidayCalendarData(HolidayCalendar holidayCalendar) {
    HolidayCalendarData holidayCalendarData = new HolidayCalendarData();

    if (holidayCalendar != null) {
      holidayCalendarData.setId(holidayCalendar.getId());
      holidayCalendarData.setTitle(holidayCalendar.getTitle());
      holidayCalendarData.setStart(holidayCalendar.getStart());
      holidayCalendarData.setEnd(holidayCalendar.getEnd());
      holidayCalendarData.setAllDay(holidayCalendar.isAllDay());
      holidayCalendarData.setDraggable(holidayCalendar.isDraggable());
      holidayCalendarData.setColor(ColorsToColorsData.mapToColorsData(holidayCalendar.getColor()));
      holidayCalendarData.setResizable(ResizableToResizableData.mapToResizableData(holidayCalendar.getResizable()));
      holidayCalendarData
          .setEnteredBy(UserToUserData.mapToUserData(holidayCalendar.getEnteredBy()));
    }
    return holidayCalendarData;
  }

  public static List<HolidayCalendarData> mapToHolidayCalendarDataList(
      List<HolidayCalendar> holidayCalendarList) {
    List<HolidayCalendarData> holidayCalendarDataList = new ArrayList<HolidayCalendarData>();

    if (holidayCalendarList != null) {
      for (HolidayCalendar holidayCalender : holidayCalendarList) {
        holidayCalendarDataList.add(mapToHolidayCalendarData(holidayCalender));
      }
    }
    return holidayCalendarDataList;
  }
}
