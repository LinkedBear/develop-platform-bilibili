package com.linkedbear.platform.application.advisor;

import com.linkedbear.platform.core.enhancer.methodadvisor.MethodAdvisor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Scope("prototype")
@Component
public class StopWatchAdvisor implements MethodAdvisor {
    
    private StopWatch stopWatch = new StopWatch("StopWatchAdvisor");
    
    @Override
    public boolean before() {
        stopWatch.start();
        return MethodAdvisor.super.before();
    }
    
    @Override
    public void after() {
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}