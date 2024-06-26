package com.linkedbear.platform.core.enhancer.validation.validator;

import cn.hutool.core.lang.Validator;
import com.linkedbear.platform.core.enhancer.validation.AbstractRequiredStringValidator;
import com.linkedbear.platform.core.enhancer.validation.annotation.Regex;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author LinkedBear
 */
public class RegexValidator extends AbstractRequiredStringValidator<Regex> {
    
    private String regex;
    
    @Override
    public void initialize(Regex anno) {
        super.initialize(anno);
        this.regex = anno.value();
    }
    
    @Override
    protected boolean doValid(String value, ConstraintValidatorContext context) {
        return Validator.isMatchRegex(regex, value);
    }
}
