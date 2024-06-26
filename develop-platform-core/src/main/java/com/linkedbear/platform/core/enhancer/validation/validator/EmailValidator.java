package com.linkedbear.platform.core.enhancer.validation.validator;

import cn.hutool.core.lang.Validator;
import com.linkedbear.platform.core.enhancer.validation.AbstractRequiredStringValidator;
import com.linkedbear.platform.core.enhancer.validation.annotation.Email;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author LinkedBear
 */
public class EmailValidator extends AbstractRequiredStringValidator<Email> {
    
    @Override
    protected boolean doValid(String value, ConstraintValidatorContext context) {
        return Validator.isEmail(value);
    }
}
