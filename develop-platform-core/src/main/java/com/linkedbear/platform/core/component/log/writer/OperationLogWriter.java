package com.linkedbear.platform.core.component.log.writer;

import com.linkedbear.platform.core.component.log.OperationLogDO;

public interface OperationLogWriter {
    
    void write(OperationLogDO log);
}
