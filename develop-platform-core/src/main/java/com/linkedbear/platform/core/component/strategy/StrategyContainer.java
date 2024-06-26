package com.linkedbear.platform.core.component.strategy;

import com.linkedbear.platform.core.enhancer.exception.PlatformException;
import com.linkedbear.platform.core.util.spring.ApplicationContextHolder;

/**
 * 策略容器，封装了获取策略和执行策略的方法
 */
public abstract class StrategyContainer {
    
    public static <T, R> Strategy<T, R> getStrategy(Class<? extends Strategy<T, R>> strategyClass, T value, Object param) {
        return ApplicationContextHolder.getBeans(strategyClass).stream().filter(i -> i.support(value, param)).findAny()
                .orElseThrow(() -> new PlatformException("没有匹配到可供支持的策略分支"));
    }
    
    public static <T, R> R invokeStrategy(Class<? extends Strategy<T, R>> strategyClass, T value, Object param) {
        return getStrategy(strategyClass, value, param).invoke(value);
    }
}
