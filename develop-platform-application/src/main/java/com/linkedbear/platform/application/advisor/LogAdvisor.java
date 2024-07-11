package com.linkedbear.platform.application.advisor;

import com.linkedbear.platform.application.vo.Person;
import com.linkedbear.platform.core.enhancer.methodadvisor.MethodAdvisor;
import com.linkedbear.platform.core.enhancer.methodadvisor.MethodContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogAdvisor implements MethodAdvisor<Person> {
    
    @Override
    public boolean before() {
        MethodContext<Person> context = MethodContext.getContext();
        Person data = context.getData();
        log.info("Log print ......");
        System.out.println(data.getName());
        return MethodAdvisor.super.before();
    }
}
