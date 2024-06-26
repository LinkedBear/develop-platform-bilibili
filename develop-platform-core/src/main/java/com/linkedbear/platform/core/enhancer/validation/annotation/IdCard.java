package com.linkedbear.platform.core.enhancer.validation.annotation;

import com.linkedbear.platform.core.enhancer.validation.validator.IdCardValidator;
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
@Constraint(validatedBy = IdCardValidator.class)
public @interface IdCard {
    
    String message() default "身份证号格式或内容不正确";
    
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default { };
    
    boolean required() default false;
}
