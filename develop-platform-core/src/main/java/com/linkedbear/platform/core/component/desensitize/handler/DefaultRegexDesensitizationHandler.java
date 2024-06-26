package com.linkedbear.platform.core.component.desensitize.handler;

import com.linkedbear.platform.core.component.desensitize.annotation.RegexDesensitize;

/**
 * 基于正则表达式替换的脱敏处理器
 */
public class DefaultRegexDesensitizationHandler implements DesensitizationHandler<RegexDesensitize> {
    
    @Override
    public String desensitize(String origin, RegexDesensitize annotation) {
        return origin.replaceAll(annotation.regex(), annotation.replacer());
    }
}
