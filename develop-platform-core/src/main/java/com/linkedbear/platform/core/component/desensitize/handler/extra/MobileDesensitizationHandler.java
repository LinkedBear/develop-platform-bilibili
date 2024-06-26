package com.linkedbear.platform.core.component.desensitize.handler.extra;

import com.linkedbear.platform.core.component.desensitize.annotation.extra.MobileDesensitize;
import com.linkedbear.platform.core.component.desensitize.handler.AbstractSliderDesensitizationHandler;

/**
 * @author LinkedBear
 */
public class MobileDesensitizationHandler extends AbstractSliderDesensitizationHandler<MobileDesensitize> {
    
    @Override
    public Integer getPrefixKeep(MobileDesensitize annotation) {
        return annotation.prefixKeep();
    }
    
    @Override
    public Integer getSuffixKeep(MobileDesensitize annotation) {
        return annotation.suffixKeep();
    }
    
    @Override
    public String getReplacer(MobileDesensitize annotation) {
        return annotation.replacer();
    }
}
