package com.linkedbear.platform.application.advisor;

import com.linkedbear.platform.core.enhancer.methodadvisor.MethodAdvisor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogAdvisor implements MethodAdvisor {
    
    @Override
    public boolean before() {
        log.info("Log print ......");
        return MethodAdvisor.super.before();
    }
}
