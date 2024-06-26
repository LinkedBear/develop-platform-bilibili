package com.linkedbear.platform.core.component.desensitize.handler.extra;

import com.linkedbear.platform.core.component.desensitize.annotation.extra.IdCardDesensitize;
import com.linkedbear.platform.core.component.desensitize.handler.AbstractSliderDesensitizationHandler;

/**
 * @author LinkedBear
 */
public class IdCardDesensitizationHandler extends AbstractSliderDesensitizationHandler<IdCardDesensitize> {
    
    @Override
    public Integer getPrefixKeep(IdCardDesensitize annotation) {
        return annotation.prefixKeep();
    }
    
    @Override
    public Integer getSuffixKeep(IdCardDesensitize annotation) {
        return annotation.suffixKeep();
    }
    
    @Override
    public String getReplacer(IdCardDesensitize annotation) {
        return annotation.replacer();
    }
}
