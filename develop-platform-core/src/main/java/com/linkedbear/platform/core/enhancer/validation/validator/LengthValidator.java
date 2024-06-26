package com.linkedbear.platform.core.enhancer.validation.validator;

import cn.hutool.core.util.StrUtil;
import com.linkedbear.platform.core.enhancer.validation.annotation.Length;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author LinkedBear
 */
public class LengthValidator implements ConstraintValidator<Length, String> {
    
    private int length;
    
    @Override
    public void initialize(Length anno) {
        this.length = anno.value();
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StrUtil.length(value) == length;
    }
}
