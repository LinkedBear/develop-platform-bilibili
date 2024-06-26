package com.linkedbear.platform.core.enhancer.validation.annotation;

import com.linkedbear.platform.core.enhancer.validation.validator.LengthValidator;
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
@Constraint(validatedBy = LengthValidator.class)
public @interface Length {
    
    String message() default "长度不符合要求！";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
    
    int value();
}
