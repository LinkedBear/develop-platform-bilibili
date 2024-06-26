package com.linkedbear.platform.core.component.limit.aspect;

import com.linkedbear.platform.core.component.limit.MethodLevelScopeEnum;
import com.linkedbear.platform.core.component.limit.annotation.RequestLimit;
import com.linkedbear.platform.core.component.limit.container.LimitCacheContainer;
import com.linkedbear.platform.core.enhancer.exception.extend.RequestLimitException;
import com.linkedbear.platform.core.enhancer.spring.aop.GenericAspectSupport;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

import java.lang.reflect.Method;

/**
 * 请求限流的切面 <br/>
 * 基于访问域的限流，可支持全局、部门级、个人级限流
 * @author LinkedBear
 */
@Aspect
public class RequestLimitAspect extends GenericAspectSupport implements Ordered {
    
    private final LimitCacheContainer cacheContainer;
    
    public RequestLimitAspect(LimitCacheContainer cacheContainer) {
        this.cacheContainer = cacheContainer;
    }
    
    @Around("@annotation(com.linkedbear.platform.core.component.limit.annotation.RequestLimit)")
    public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = this.getTargetMethod(joinPoint);
        RequestLimit requestLimit = method.getAnnotation(RequestLimit.class);
        // 解析限流域
        String scopeKey = MethodLevelScopeEnum.getScopeKey(method, requestLimit.scope());
        if (cacheContainer.getCount(scopeKey) >= requestLimit.rate()) {
            throw new RequestLimitException(requestLimit.message());
        }
        cacheContainer.addCount(scopeKey, requestLimit.interval(), requestLimit.unit());
        return joinPoint.proceed();
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
