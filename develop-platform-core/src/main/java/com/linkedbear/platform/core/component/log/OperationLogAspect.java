package com.linkedbear.platform.core.component.log;

import com.linkedbear.platform.core.component.log.annotation.OperationLog;
import com.linkedbear.platform.core.component.log.writer.OperationLogWriter;
import com.linkedbear.platform.core.enhancer.spring.aop.GenericAspectSupport;
import com.linkedbear.platform.core.util.lang.DateFormatUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
public class OperationLogAspect extends GenericAspectSupport {
    
    @Autowired
    private OperationLogWriter operationLogWriter;
    
    @Around("@annotation(com.linkedbear.platform.core.component.log.annotation.OperationLog)")
    public Object writeOperationLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String now = DateFormatUtils.formatDatetime();
        Object target = joinPoint.getTarget();
        Method method = this.getTargetMethod(joinPoint);
        Object[] args = joinPoint.getArgs();
        Object proceed = joinPoint.proceed();
        OperationLog operationLog = method.getAnnotation(OperationLog.class);
        String business = operationLog.value();
        // 写入操作日志
        OperationLogDO logDO = new OperationLogDO(now, business, target.getClass().getName(), method.getName(),
                Arrays.toString(args), proceed.toString());
        operationLogWriter.write(logDO);
        return proceed;
    }
}
