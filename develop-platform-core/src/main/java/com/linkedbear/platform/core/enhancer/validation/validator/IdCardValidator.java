package com.linkedbear.platform.core.enhancer.validation.validator;

import cn.hutool.core.lang.Validator;
import com.linkedbear.platform.core.enhancer.validation.AbstractRequiredStringValidator;
import com.linkedbear.platform.core.enhancer.validation.annotation.IdCard;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author LinkedBear
 */
public class IdCardValidator extends AbstractRequiredStringValidator<IdCard> {
    
    @Override
    protected boolean doValid(String value, ConstraintValidatorContext context) {
        return Validator.isCitizenId(value);
    }
}
