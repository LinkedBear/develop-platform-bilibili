package com.linkedbear.platform.core.component.desensitize.handler;

import com.linkedbear.platform.core.component.desensitize.annotation.SliderDesensitize;

/**
 * 基于 {@link SliderDesensitize} 注解实现的默认滑动脱敏
 * @author LinkedBear
 */
public class DefaultSliderDesensitizationHandler extends AbstractSliderDesensitizationHandler<SliderDesensitize> {
    
    @Override
    public Integer getPrefixKeep(SliderDesensitize annotation) {
        return annotation.prefixKeep();
    }
    
    @Override
    public Integer getSuffixKeep(SliderDesensitize annotation) {
        return annotation.suffixKeep();
    }
    
    @Override
    public String getReplacer(SliderDesensitize annotation) {
        return annotation.replacer();
    }
}
