package com.linkedbear.platform.core.component.desensitize.handler.extra;

import com.linkedbear.platform.core.component.desensitize.annotation.extra.PasswordDesensitize;
import com.linkedbear.platform.core.component.desensitize.handler.AbstractSliderDesensitizationHandler;

/**
 * @author LinkedBear
 */
public class PasswordDesensitizationHandler extends AbstractSliderDesensitizationHandler<PasswordDesensitize> {
    
    @Override
    public Integer getPrefixKeep(PasswordDesensitize annotation) {
        return annotation.prefixKeep();
    }
    
    @Override
    public Integer getSuffixKeep(PasswordDesensitize annotation) {
        return annotation.suffixKeep();
    }
    
    @Override
    public String getReplacer(PasswordDesensitize annotation) {
        return annotation.replacer();
    }
}
