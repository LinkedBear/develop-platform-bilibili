package com.linkedbear.platform.core.component.desensitize.annotation.extra;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.linkedbear.platform.core.component.desensitize.annotation.Desensitize;
import com.linkedbear.platform.core.component.desensitize.handler.extra.IdCardDesensitizationHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 身份证号脱敏，只保留前4后2
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@Desensitize(handler = IdCardDesensitizationHandler.class)
public @interface IdCardDesensitize {
    
    String replacer() default "*";
    
    int prefixKeep() default 4;
    
    int suffixKeep() default 2;
}
