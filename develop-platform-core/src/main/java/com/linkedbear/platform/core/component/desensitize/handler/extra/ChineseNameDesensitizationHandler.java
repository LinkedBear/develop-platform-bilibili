package com.linkedbear.platform.core.component.desensitize.handler.extra;

import com.linkedbear.platform.core.component.desensitize.annotation.extra.ChineseNameDesensitize;
import com.linkedbear.platform.core.component.desensitize.handler.AbstractSliderDesensitizationHandler;

/**
 * @author LinkedBear
 */
public class ChineseNameDesensitizationHandler extends AbstractSliderDesensitizationHandler<ChineseNameDesensitize> {
    
    @Override
    public Integer getPrefixKeep(ChineseNameDesensitize annotation) {
        return annotation.prefixKeep();
    }
    
    @Override
    public Integer getSuffixKeep(ChineseNameDesensitize annotation) {
        return annotation.suffixKeep();
    }
    
    @Override
    public String getReplacer(ChineseNameDesensitize annotation) {
        return annotation.replacer();
    }
}
