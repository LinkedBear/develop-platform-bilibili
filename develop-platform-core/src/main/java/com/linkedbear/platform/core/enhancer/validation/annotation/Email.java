package com.linkedbear.platform.core.enhancer.validation.annotation;

import com.linkedbear.platform.core.enhancer.validation.validator.EmailValidator;
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
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {
    
    String message() default "邮箱格式不正确";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
    
    boolean required() default false;
}
