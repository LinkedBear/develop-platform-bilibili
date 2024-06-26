package com.linkedbear.platform.core.enhancer.validation.validator;

import cn.hutool.core.lang.Validator;
import com.linkedbear.platform.core.enhancer.validation.AbstractRequiredStringValidator;
import com.linkedbear.platform.core.enhancer.validation.annotation.MobilePhone;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author LinkedBear
 */
public class MobilePhoneValidator extends AbstractRequiredStringValidator<MobilePhone> {
    
    @Override
    protected boolean doValid(String value, ConstraintValidatorContext context) {
        return Validator.isMobile(value);
    }
}
