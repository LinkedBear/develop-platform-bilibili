package com.linkedbear.platform.core.component.log.writer;

import com.linkedbear.platform.core.util.lang.DateFormatUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerBusinessLogWriter implements BusinessLogWriter {
    
    @Override
    public void write(String method, String description) {
        log.info("{} ----- {} ------ {}", DateFormatUtils.formatDatetime(), method, description);
    }
}
