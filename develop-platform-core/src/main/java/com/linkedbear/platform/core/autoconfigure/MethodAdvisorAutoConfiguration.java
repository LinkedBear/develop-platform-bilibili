package com.linkedbear.platform.core.autoconfigure;

import com.linkedbear.platform.core.enhancer.methodadvisor.MethodAdvisorAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class MethodAdvisorAutoConfiguration {
    
    @Bean
    public MethodAdvisorAspect methodAdvisorAspect() {
        return new MethodAdvisorAspect();
    }
}
