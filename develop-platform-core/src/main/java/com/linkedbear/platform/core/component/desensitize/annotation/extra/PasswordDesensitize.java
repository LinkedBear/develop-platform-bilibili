package com.linkedbear.platform.core.component.desensitize.annotation.extra;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.linkedbear.platform.core.component.desensitize.annotation.Desensitize;
import com.linkedbear.platform.core.component.desensitize.handler.extra.PasswordDesensitizationHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 密码脱敏，全部屏蔽
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@Desensitize(handler = PasswordDesensitizationHandler.class)
public @interface PasswordDesensitize {
    
    String replacer() default "*";
    
    int prefixKeep() default 0;
    
    int suffixKeep() default 0;
}
