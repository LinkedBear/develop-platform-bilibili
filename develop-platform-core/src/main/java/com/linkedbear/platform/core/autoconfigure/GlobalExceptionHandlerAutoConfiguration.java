package com.linkedbear.platform.core.autoconfigure;

import com.linkedbear.platform.core.enhancer.exception.BasicErrorAttribute;
import com.linkedbear.platform.core.enhancer.exception.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 基本异常类型处理配置 <br/>
 * NOTE: 该自动配置会提前于ErrorMvcAutoConfiguration执行，以避免产生两个ErrorAttribute
 * @author LinkedBear
 */
@AutoConfiguration(before = ErrorMvcAutoConfiguration.class)
public class GlobalExceptionHandlerAutoConfiguration {
    
    @Bean
    public BasicErrorAttribute basicErrorAttribute() {
        return new BasicErrorAttribute();
    }
    
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
