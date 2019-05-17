package com.sgic.hrm.commons.dto.mapper;

import com.sgic.hrm.commons.dto.ResizableData;
import com.sgic.hrm.commons.entity.Resizable;

public class ResizableDataToResizable {

  public static Resizable mapToResizable(ResizableData resizableData) {
    
    Resizable resizable = new Resizable();
    
    if(resizableData != null) {      
      resizable.setId(resizableData.getId());
      resizable.setAfterEnd(resizableData.isAfterEnd());
      resizable.setBeforeStart(resizableData.isBeforeStart());
      
      return resizable;
    }
    return null;
  }
}
