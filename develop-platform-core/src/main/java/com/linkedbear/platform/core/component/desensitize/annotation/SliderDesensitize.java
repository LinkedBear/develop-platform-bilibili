package com.linkedbear.platform.core.component.desensitize.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.linkedbear.platform.core.component.desensitize.handler.DefaultSliderDesensitizationHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 通用滑动脱敏注解，只保留前后n位内容，中间部分脱敏
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@JacksonAnnotationsInside
@Desensitize(handler = DefaultSliderDesensitizationHandler.class)
public @interface SliderDesensitize {
    
    /**
     * 替换规则，会将前缀后缀保留后，全部替换成 replacer <br>
     * 例如：prefixKeep = 1; suffixKeep = 2; replacer = "*"; <br>
     * 原始字符串  123456 <br>
     * 脱敏后     1***56
     */
    String replacer() default "*";
    
    /**
     * 前缀保留长度
     */
    int prefixKeep() default 0;
    
    /**
     * 后缀保留长度
     */
    int suffixKeep() default 0;
}
