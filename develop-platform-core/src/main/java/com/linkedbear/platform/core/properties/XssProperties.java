package com.linkedbear.platform.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * XSS相关的配置
 * @author LinkedBear
 */
@ConfigurationProperties(prefix = "platform.xss")
public class XssProperties {
    
    private boolean enable = true;
    
    /**
     * xss不处理的路径
     */
    private List<String> exclude;
    
    public boolean isEnable() {
        return enable;
    }
    
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    public List<String> getExclude() {
        return exclude;
    }
    
    public void setExclude(List<String> exclude) {
        this.exclude = exclude;
    }
}
