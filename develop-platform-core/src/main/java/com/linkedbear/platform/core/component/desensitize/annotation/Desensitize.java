package com.linkedbear.platform.core.component.desensitize.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.linkedbear.platform.core.component.desensitize.StringDesensitizeSerializer;
import com.linkedbear.platform.core.component.desensitize.handler.DesensitizationHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据脱敏的基础注解，扩展脱敏规则时需要使用当前注解
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@JacksonAnnotationsInside
@JsonSerialize(using = StringDesensitizeSerializer.class)
public @interface Desensitize {
    
    /**
     * 脱敏处理器
     */
    Class<? extends DesensitizationHandler> handler();
}
