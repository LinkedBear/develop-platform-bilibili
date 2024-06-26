package com.linkedbear.platform.core.component.hotswap;

import org.springframework.aop.support.AopUtils;
import org.springframework.aop.target.HotSwappableTargetSource;

import java.util.HashMap;
import java.util.Map;

/**
 * 单独管理TargetSource的容器（解决基于构造器的循环依赖）
 * @author LinkedBear
 */
public class TargetSourceContainer {
    
    private static Map<String, HotSwappableTargetSource> targetSourceMap = new HashMap<>();
    
    public static synchronized HotSwappableTargetSource getTargetSource(Object obj) {
        Class<?> clazz = AopUtils.isAopProxy(obj) ? AopUtils.getTargetClass(obj) : obj.getClass();
        if (!targetSourceMap.containsKey(clazz.getName())) {
            targetSourceMap.put(clazz.getName(), new HotSwappableTargetSource(obj));
        }
        return targetSourceMap.get(clazz.getName());
    }
}
