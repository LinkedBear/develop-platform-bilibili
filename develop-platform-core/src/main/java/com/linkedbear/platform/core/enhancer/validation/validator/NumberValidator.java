package com.linkedbear.platform.core.enhancer.validation.validator;

import cn.hutool.core.lang.Validator;
import com.linkedbear.platform.core.enhancer.validation.AbstractRequiredStringValidator;
import com.linkedbear.platform.core.enhancer.validation.annotation.Number;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author LinkedBear
 */
public class NumberValidator extends AbstractRequiredStringValidator<Number> {
    
    private int length;
    
    @Override
    public void initialize(Number anno) {
        super.initialize(anno);
        this.length = anno.length();
    }
    
    @Override
    protected boolean doValid(String value, ConstraintValidatorContext context) {
        if (Validator.isNumber(value)) {
            return length >= 0 && value.length() == length;
        }
        return false;
    }
}
