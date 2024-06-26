package com.linkedbear.platform.core.enhancer.validation.annotation;

import com.linkedbear.platform.core.enhancer.validation.validator.RegexValidator;
import jakarta.validation.Constraint;
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
@Constraint(validatedBy = RegexValidator.class)
public @interface Regex {
    
    String message() default "输入的格式不正确";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
    
    String value();
    
    /**
     * 是否必须传入不为空的值，默认不必须（即传null和空串视为通过）
     * @return
     */
    boolean required() default false;
}
