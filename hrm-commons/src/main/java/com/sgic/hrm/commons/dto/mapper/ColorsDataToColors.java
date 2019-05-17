package com.sgic.hrm.commons.dto.mapper;

import com.sgic.hrm.commons.dto.ColorsData;
import com.sgic.hrm.commons.entity.Colors;

public class ColorsDataToColors {

  public static Colors mapToColors(ColorsData colorsData) {
    
    Colors colors = new Colors();
    
    if(colorsData != null) {
    colors.setId(colorsData.getId());
    colors.setName(colorsData.getName());
    colors.setPrimary(colorsData.getPrimary());
    colors.setSecondary(colorsData.getSecondary());
    
    return colors;
    }
    return null;
  }
}
