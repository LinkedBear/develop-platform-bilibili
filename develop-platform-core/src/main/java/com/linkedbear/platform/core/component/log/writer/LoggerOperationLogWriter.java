package com.linkedbear.platform.core.component.log.writer;

import com.linkedbear.platform.core.component.log.OperationLogDO;
import com.linkedbear.platform.core.util.http.HttpUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerOperationLogWriter implements OperationLogWriter {
    
    @Override
    public void write(OperationLogDO logDO) {
        log.info("{} ------ 业务动作：{}，触发方法：{}#{}，入参：{}，返回值：{}，客户端来源：{}", logDO.getOperationTime(),
                logDO.getBusiness(), logDO.getTarget(), logDO.getMethod(), logDO.getArgs(), logDO.getReturnValue(),
                HttpUtils.getRequestIp());
    }
}
