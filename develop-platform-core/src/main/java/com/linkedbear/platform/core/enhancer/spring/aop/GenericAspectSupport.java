package com.linkedbear.platform.core.enhancer.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Aspect切面类的简单封装
 * @author LinkedBear
 */
public abstract class GenericAspectSupport {
    
    /**
     * 基于环绕通知的目标方法获取，如果获取到的方法来自于接口，则反射向下找实现类的方法
     * @param joinPoint
     * @return
     */
    protected Method getTargetMethod(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method.getDeclaringClass().isInterface()) {
            method = ReflectionUtils.findMethod(joinPoint.getTarget().getClass(), method.getName(), method.getParameterTypes());
        }
        return method;
    }
    
    /**
     * 基于环绕通知的目标方法获取，不考虑方法定义来自接口还是实现类
     * @param joinPoint
     * @return
     */
    protected Method getTargetMethodWithoutImpl(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
    
    /**
     * 将被切入方法的参数名和参数值封装为Map
     * @param joinPoint
     * @return
     */
    protected Map<String, Object> convertParamsMap(ProceedingJoinPoint joinPoint) {
        return convertParamsMap(joinPoint, null);
    }
    
    /**
     * 将被切入方法的参数名和参数值封装为Map，并对其中一些特殊参数进行后置处理
     * @param joinPoint
     * @param postProcessor
     * @return
     */
    protected Map<String, Object> convertParamsMap(ProceedingJoinPoint joinPoint,
            @Nullable Consumer<Map<String, Object>> postProcessor) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        Map<String, Object> paramMap = new HashMap<>(parameterNames.length);
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }
        if (postProcessor != null) {
            postProcessor.accept(paramMap);
        }
        return paramMap;
    }
}
