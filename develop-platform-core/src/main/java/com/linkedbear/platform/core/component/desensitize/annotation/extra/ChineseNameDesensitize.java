package com.linkedbear.platform.core.component.desensitize.annotation.extra;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.linkedbear.platform.core.component.desensitize.annotation.Desensitize;
import com.linkedbear.platform.core.component.desensitize.handler.extra.ChineseNameDesensitizationHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 姓名脱敏，只保留第一个字
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@Desensitize(handler = ChineseNameDesensitizationHandler.class)
public @interface ChineseNameDesensitize {
    
    String replacer() default "*";
    
    int prefixKeep() default 1;
    
    int suffixKeep() default 0;
}
