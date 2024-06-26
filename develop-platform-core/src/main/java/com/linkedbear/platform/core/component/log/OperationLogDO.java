package com.linkedbear.platform.core.component.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class OperationLogDO {
    
    private String operationTime;
    private String business;
    private String target;
    private String method;
    private String args;
    private String returnValue;
}
