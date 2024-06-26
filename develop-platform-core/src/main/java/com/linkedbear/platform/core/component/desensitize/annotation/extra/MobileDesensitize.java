package com.linkedbear.platform.core.component.desensitize.annotation.extra;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.linkedbear.platform.core.component.desensitize.annotation.Desensitize;
import com.linkedbear.platform.core.component.desensitize.handler.extra.MobileDesensitizationHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 手机号脱敏注解
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@Desensitize(handler = MobileDesensitizationHandler.class)
public @interface MobileDesensitize {
    
    String replacer() default "*";
    
    int prefixKeep() default 3;
    
    int suffixKeep() default 4;
}
