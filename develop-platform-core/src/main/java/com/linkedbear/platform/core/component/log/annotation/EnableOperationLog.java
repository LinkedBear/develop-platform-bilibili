package com.linkedbear.platform.core.component.log.annotation;

import com.linkedbear.platform.core.autoconfigure.OperationLogAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(OperationLogAutoConfiguration.Marker.class)
public @interface EnableOperationLog {
    
}
