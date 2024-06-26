package com.linkedbear.platform.core.component.limit.annotation;

import com.linkedbear.platform.core.autoconfigure.RequestLimitAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接口防刷
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(RequestLimitAutoConfiguration.Marker.class)
public @interface EnableRequestLimit {
    
}
