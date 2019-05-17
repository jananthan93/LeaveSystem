package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sgic.hrm.commons.dto.ColorsData;
import com.sgic.hrm.commons.entity.Colors;

public class ColorsToColorsData {

public static ColorsData mapToColorsData(Colors colors) {
    
    ColorsData colorsData = new ColorsData();
    
    if(colors != null) {
    colorsData.setId(colors.getId());
    colorsData.setName(colors.getName());
    colorsData.setPrimary(colors.getPrimary());
    colorsData.setSecondary(colors.getSecondary());
    
    return colorsData;
    }
    return null;
  }

public static List<ColorsData> mapToColorsDataList(List<Colors> colorsList){
	List<ColorsData> colorsDataList = new ArrayList<ColorsData>();
	if(colorsList!=null) {
		for (Colors colors :colorsList) {
			colorsDataList.add(mapToColorsData(colors));
		}
	}
	return colorsDataList;
	
	}
}
