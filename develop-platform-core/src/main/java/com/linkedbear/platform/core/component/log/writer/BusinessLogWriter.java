package com.linkedbear.platform.core.component.log.writer;

import com.linkedbear.platform.core.util.spring.ApplicationContextHolder;

public interface BusinessLogWriter {
    
    void write(String method, String description);
    
    static void writeLog(String method, String description) {
        // 发起请假审批
        // 请假审批通过  /  驳回
        
        // xxx操作了xxx
        // xxx就xxx业务发起了xxxxx
        ApplicationContextHolder.getBean(BusinessLogWriter.class).write(method, description);
    }
}
