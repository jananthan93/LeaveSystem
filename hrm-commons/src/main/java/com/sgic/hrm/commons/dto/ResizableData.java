package com.sgic.hrm.commons.dto;

public class ResizableData {

  private Integer id;
  private boolean beforeStart;
  private boolean afterEnd;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isBeforeStart() {
    return beforeStart;
  }

  public void setBeforeStart(boolean beforeStart) {
    this.beforeStart = beforeStart;
  }

  public boolean isAfterEnd() {
    return afterEnd;
  }

  public void setAfterEnd(boolean afterEnd) {
    this.afterEnd = afterEnd;
  }

}
