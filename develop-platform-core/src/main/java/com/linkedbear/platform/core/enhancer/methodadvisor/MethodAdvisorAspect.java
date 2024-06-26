package com.linkedbear.platform.core.enhancer.methodadvisor;

import cn.hutool.core.collection.CollUtil;
import com.linkedbear.platform.core.enhancer.spring.aop.GenericAspectSupport;
import com.linkedbear.platform.core.util.spring.ApplicationContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.NamedThreadLocal;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
public class MethodAdvisorAspect extends GenericAspectSupport {
    
    private static final ThreadLocal<MethodContext> LOCAL = new NamedThreadLocal("LOCAL");
    
    @Around("@annotation(com.linkedbear.platform.core.enhancer.methodadvisor.MethodAdvisors)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = this.getTargetMethod(joinPoint);
        Class<? extends MethodAdvisor>[] advisorClasses = method.getAnnotation(MethodAdvisors.class).value();
        List<? extends MethodAdvisor> advisors = Arrays.stream(advisorClasses).map(ApplicationContextHolder::getBean)
                .collect(Collectors.toList());
        MethodContext old = LOCAL.get();
        LOCAL.set(new MethodContext(old));
        for (MethodAdvisor advisor : advisors) {
            if (!advisor.before()) {
                break;
            }
        }
        Object returnValue = joinPoint.proceed();
        for (MethodAdvisor advisor : CollUtil.reverse(advisors)) {
            advisor.after();
        }
        LOCAL.set(old);
        return returnValue;
    }
    
    public static <E> MethodContext<E> getContext() {
        return LOCAL.get();
    }
}
