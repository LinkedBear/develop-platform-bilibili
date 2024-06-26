package com.linkedbear.platform.core.autoconfigure;

import com.linkedbear.platform.core.component.log.writer.BusinessLogWriter;
import com.linkedbear.platform.core.component.log.writer.LoggerBusinessLogWriter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class BusinessLogAutoConfiguration {
    
    @Bean
    @ConditionalOnMissingBean
    public BusinessLogWriter businessLogWriter() {
        return new LoggerBusinessLogWriter();
    }
}
