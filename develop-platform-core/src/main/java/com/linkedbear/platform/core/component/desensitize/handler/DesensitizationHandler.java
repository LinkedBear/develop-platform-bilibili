package com.linkedbear.platform.core.component.desensitize.handler;

import java.lang.annotation.Annotation;

/**
 * 脱敏处理器接口
 * @author LinkedBear
 */
@FunctionalInterface
public interface DesensitizationHandler<T extends Annotation> {
    
    /**
     * 数据脱敏
     * @param origin 原始数据
     * @param annotation 注解信息
     * @return 脱敏后的数据
     */
    String desensitize(String origin, T annotation);
}
