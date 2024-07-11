package com.linkedbear.platform.application.service;

import cn.hutool.core.util.RandomUtil;
import com.linkedbear.platform.application.advisor.BusinessLogAdvisor;
import com.linkedbear.platform.application.advisor.LogAdvisor;
import com.linkedbear.platform.application.advisor.StopWatchAdvisor;
import com.linkedbear.platform.core.component.log.OperationLogDO;
import com.linkedbear.platform.core.component.log.writer.BusinessLogWriter;
import com.linkedbear.platform.core.component.log.writer.OperationLogWriter;
import com.linkedbear.platform.core.enhancer.methodadvisor.MethodAdvisors;
import com.linkedbear.platform.core.enhancer.methodadvisor.MethodContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import static com.linkedbear.platform.application.advisor.BusinessLogAdvisor.LOG_FIELD;

@Slf4j
@Service
public class MethodAdvisorService {
    
    private StopWatch stopWatch = new StopWatch("MethodAdvisorService");
    
//    @Autowired
    private OperationLogWriter operationLogWriter;
    
    @MethodAdvisors({LogAdvisor.class, StopWatchAdvisor.class, BusinessLogAdvisor.class})
    public void test(String name) {
        System.out.println("MethodAdvisorService 执行业务逻辑 ......");
        try {
            Thread.sleep(500 + RandomUtil.randomInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MethodContext.getContext().getExt().put(LOG_FIELD, new BusinessLogAdvisor.BusinessLogDO("测试方法", "test方法被触发"));
    }
    
    @MethodAdvisors({LogAdvisor.class})
    public void test2() {
        System.out.println("MethodAdvisorService 执行业务逻辑 ......");
    }
    
    @MethodAdvisors({LogAdvisor.class, StopWatchAdvisor.class})
    public void test3() {
        System.out.println("MethodAdvisorService 执行业务逻辑 ......");
    }
    
    @MethodAdvisors({StopWatchAdvisor.class, BusinessLogAdvisor.class})
    public void test4() {
        System.out.println("MethodAdvisorService 执行业务逻辑 ......");
    }
}
