package com.sgic.hrm.commons.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sgic.hrm.commons.dto.ResizableData;
import com.sgic.hrm.commons.entity.Resizable;

public class ResizableToResizableData {

 public static ResizableData mapToResizableData(Resizable resizable) {
    
    ResizableData resizableData = new ResizableData();
    
    if(resizable != null) {      
      resizableData.setId(resizable.getId());
      resizableData.setAfterEnd(resizable.isAfterEnd());
      resizableData.setBeforeStart(resizable.isBeforeStart());
      
      return resizableData;
    }
    return null;
  }
 
 public static List<ResizableData> mapToResizableList(List<Resizable> resizableList){
		List<ResizableData> resizableDataList = new ArrayList<ResizableData>();
		if(resizableList!=null) {
			for (Resizable resizable :resizableList) {
				resizableDataList.add(mapToResizableData(resizable));
			}
		}
		return resizableDataList;
		
		}
 
 
}
