package com.linkedbear.platform.core.enhancer.exception;

import com.linkedbear.platform.core.util.lang.DateFormatUtils;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

import static com.linkedbear.platform.core.constant.PlatformConstants.ERROR_DATA;
import static com.linkedbear.platform.core.constant.PlatformConstants.ERROR_TIME;

/**
 * 扩展的基础异常属性模型
 * @author LinkedBear
 */
public class BasicErrorAttribute extends DefaultErrorAttributes {
    
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        // 额外的异常信息
        Map<String, Object> errorData = (Map<String, Object>) webRequest.getAttribute(ERROR_DATA, RequestAttributes.SCOPE_REQUEST);
        if (errorData != null) {
            map.putAll(errorData);
        }
        // 异常的捕获时间
        map.put(ERROR_TIME, DateFormatUtils.formatDatetime());
        return map;
    }
}
