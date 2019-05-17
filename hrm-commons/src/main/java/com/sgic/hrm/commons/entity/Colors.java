package com.sgic.hrm.commons.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "colors", schema = "leavesystem")
public class Colors implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -7376327954685617787L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "color_name")
  String name;

  @Column(name = "primary_color")
  String primary;

  @Column(name = "secondary_color")
  String secondary;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrimary() {
    return primary;
  }

  public void setPrimary(String primary) {
    this.primary = primary;
  }

  public String getSecondary() {
    return secondary;
  }

  public void setSecondary(String secondary) {
    this.secondary = secondary;
  }


}
