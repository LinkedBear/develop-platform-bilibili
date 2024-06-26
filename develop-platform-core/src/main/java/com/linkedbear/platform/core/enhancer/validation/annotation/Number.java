package com.linkedbear.platform.core.enhancer.validation.annotation;

import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Number {
    
    String message() default "不是正确的数字格式或不是允许的长度";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
    
    /**
     * 是否在校验确认为数字类型的前提下，额外校验长度
     * @return
     */
    int length() default -1;
    
    boolean required() default false;
}
