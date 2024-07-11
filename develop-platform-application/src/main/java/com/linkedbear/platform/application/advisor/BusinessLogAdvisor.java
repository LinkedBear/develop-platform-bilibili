package com.linkedbear.platform.application.advisor;

import com.linkedbear.platform.application.vo.Person;
import com.linkedbear.platform.core.component.log.writer.BusinessLogWriter;
import com.linkedbear.platform.core.enhancer.methodadvisor.MethodAdvisor;
import com.linkedbear.platform.core.enhancer.methodadvisor.MethodContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class BusinessLogAdvisor implements MethodAdvisor<Person> {
    
    public static final String LOG_FIELD = "businessLog";
    
    @Override
    public void after(Object returnValue) {
        MethodContext<Object> context = MethodContext.getContext();
        BusinessLogDO log = (BusinessLogDO) context.getExt().get(LOG_FIELD);
        BusinessLogWriter.writeLog(log.method, log.description);
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BusinessLogDO {
        private String method;
        private String description;
    }
}
