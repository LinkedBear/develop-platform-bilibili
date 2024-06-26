package com.linkedbear.platform.core.component.desensitize.annotation.extra;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.linkedbear.platform.core.component.desensitize.annotation.Desensitize;
import com.linkedbear.platform.core.component.desensitize.handler.extra.EmailDesensitizationHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 邮箱脱敏
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@JacksonAnnotationsInside
@Desensitize(handler = EmailDesensitizationHandler.class)
public @interface EmailDesensitize {
    
    String regex() default "(^.)[^@]*(@.*$)";
    
    String replacer() default "$1****$2";
}
