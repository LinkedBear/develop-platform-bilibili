package com.linkedbear.platform.core.component.desensitize.handler.extra;

import com.linkedbear.platform.core.component.desensitize.annotation.extra.EmailDesensitize;
import com.linkedbear.platform.core.component.desensitize.handler.DesensitizationHandler;

/**
 * @author LinkedBear
 */
public class EmailDesensitizationHandler implements DesensitizationHandler<EmailDesensitize> {
    
    @Override
    public String desensitize(String origin, EmailDesensitize annotation) {
        return origin.replaceAll(annotation.regex(), annotation.replacer());
    }
}
