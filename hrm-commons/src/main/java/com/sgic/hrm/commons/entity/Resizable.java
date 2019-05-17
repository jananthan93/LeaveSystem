package com.sgic.hrm.commons.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resizable", schema = "leavesystem")
public class Resizable implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7877374287083975915L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "before_start")
  private boolean beforeStart;
  
  @Column(name = "after_end")
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
