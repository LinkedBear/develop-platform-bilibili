package com.linkedbear.platform.core.autoconfigure;

import com.linkedbear.platform.core.component.log.OperationLogAspect;
import com.linkedbear.platform.core.component.log.writer.LoggerOperationLogWriter;
import com.linkedbear.platform.core.component.log.writer.OperationLogWriter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
//@ConditionalOnProperty(prefix = "platform.operationlog", name = "enable", havingValue = "true")
@ConditionalOnBean(OperationLogAutoConfiguration.Marker.class)
public class OperationLogAutoConfiguration {
    
    public static class Marker {
    
    }
    
    @Bean
    public OperationLogAspect operationLogAspect() {
        return new OperationLogAspect();
    }
    
    @Bean
    @ConditionalOnMissingBean
    public OperationLogWriter operationLogWriter() {
        return new LoggerOperationLogWriter();
    }
}
