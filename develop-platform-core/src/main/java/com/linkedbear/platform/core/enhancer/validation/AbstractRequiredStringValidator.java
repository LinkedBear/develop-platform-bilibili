package com.linkedbear.platform.core.enhancer.validation;

import cn.hutool.core.util.StrUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;

/**
 * 通用的支持空串是否通过的字符串校验器抽象
 * @author LinkedBear
 * @param <A>
 */
public abstract class AbstractRequiredStringValidator<A extends Annotation> implements ConstraintValidator<A, String> {
    
    private boolean required;
    
    @Override
    public void initialize(A anno) {
        this.required = (boolean) AnnotationUtils.getAnnotationAttributes(anno).get("required");
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (!required && StrUtil.isBlank(value)) || this.doValid(value, context);
    }
    
    protected abstract boolean doValid(String value, ConstraintValidatorContext context);
}
