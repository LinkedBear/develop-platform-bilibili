package com.linkedbear.platform.core.component.hotswap;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(HotSwapPostProcessorRegistrar.class)
public @interface EnableBeanHotSwap {
    
    Class<?>[] value();
}
