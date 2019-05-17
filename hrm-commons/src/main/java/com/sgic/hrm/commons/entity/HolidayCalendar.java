package com.sgic.hrm.commons.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "holiday_calendar", schema = "leavesystem")
public class HolidayCalendar implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 6215661525000035290L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "start_date")
  private Date start;
  
  @Column(name = "end_date")
  private Date end;
  
  @Column(name = "title")
  private String title;
  
  @ManyToOne
  @JoinColumn(name = "colors_id")
  private Colors color;
  
  @Column(name = "all_day")
  private boolean allDay;
  
  @OneToOne
  @JoinColumn(name = "resizable_id")
  private Resizable resizable;
  
  @Column(name = "draggable")
  private boolean draggable;

  @ManyToOne
  @JoinColumn(name = "entered_by")
  private User enteredBy;
  
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

  public Colors getColor() {
    return color;
  }

  public void setColor(Colors color) {
    this.color = color;
  }

  public boolean isAllDay() {
    return allDay;
  }

  public void setAllDay(boolean allDay) {
    this.allDay = allDay;
  }

  public Resizable getResizable() {
    return resizable;
  }

  public void setResizable(Resizable resizable) {
    this.resizable = resizable;
  }

  public boolean isDraggable() {
    return draggable;
  }

  public void setDraggable(boolean draggable) {
    this.draggable = draggable;
  }

  public User getEnteredBy() {
    return enteredBy;
  }

  public void setEnteredBy(User enteredBy) {
    this.enteredBy = enteredBy;
  }
}
