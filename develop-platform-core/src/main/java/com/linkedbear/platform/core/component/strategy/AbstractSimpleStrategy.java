package com.linkedbear.platform.core.component.strategy;

import cn.hutool.core.lang.Assert;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 简单的策略模式抽象，它使用字面量作为策略的匹配
 * @param <T>
 * @param <R>
 */
public abstract class AbstractSimpleStrategy<T, R> implements Strategy<T, R>, InitializingBean {

    protected String supportValue;
    
    @Override
    public boolean support(T value, Object param) {
        return supportValue.equalsIgnoreCase(String.valueOf(param));
    }
    
    @Override
    public void afterPropertiesSet() {
        StrategyHandle annotation = AnnotationUtils.findAnnotation(this.getClass(), StrategyHandle.class);
        Assert.notNull(annotation, "Simple Strategy implementation should declare a @StrategyHandle annotation.");
        this.supportValue = annotation.support();
    }
}
