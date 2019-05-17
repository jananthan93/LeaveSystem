package com.sgic.hrm.commons.dto;

import java.util.Date;

public class HolidayCalendarData {

  private Integer id;
  private Date start;
  private Date end;
  private String title;
  private ColorsData color;
  private boolean allDay;
  private ResizableData resizable;
  private boolean draggable;
  private UserData enteredBy;
  private String postedBy;
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ColorsData getColor() {
    return color;
  }

  public void setColor(ColorsData color) {
    this.color = color;
  }

  public boolean isAllDay() {
    return allDay;
  }

  public void setAllDay(boolean allDay) {
    this.allDay = allDay;
  }

  public ResizableData getResizable() {
    return resizable;
  }

  public void setResizable(ResizableData resizable) {
    this.resizable = resizable;
  }

  public boolean isDraggable() {
    return draggable;
  }

  public void setDraggable(boolean draggable) {
    this.draggable = draggable;
  }

  public UserData getEnteredBy() {
    return enteredBy;
  }

  public void setEnteredBy(UserData enteredBy) {
    this.enteredBy = enteredBy;
  }

  public String getPostedBy() {    
    return postedBy;
  }

  public void setPostedBy(String postedBy) {
    this.postedBy = postedBy;
  }
  
}
