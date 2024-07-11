package com.linkedbear.platform.core.autoconfigure;

import com.linkedbear.platform.core.properties.XssProperties;
import com.linkedbear.platform.core.security.xss.XssFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 防止XSS攻击的自动装配
 * @author LinkedBear
 */
@AutoConfiguration
@ConditionalOnProperty(prefix = "platform.xss", name = "enable", havingValue = "true")
@EnableConfigurationProperties(XssProperties.class)
public class XssAutoConfiguration {
    
    @Autowired
    private XssProperties xssProperties;
    
    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        XssFilter xssFilter = new XssFilter();
        xssFilter.setExcludes(xssProperties.getExclude());
        FilterRegistrationBean registration = new FilterRegistrationBean(xssFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
}
