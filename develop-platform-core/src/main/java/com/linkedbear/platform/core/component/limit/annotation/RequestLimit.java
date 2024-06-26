package com.linkedbear.platform.core.component.limit.annotation;

import com.linkedbear.platform.core.component.limit.MethodLevelScopeEnum;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * 接口限流，可限制类 / 方法的请求频率
 * @author LinkedBear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RequestLimit {
    
    /**
     * 限流级别，默认为全局限制
     * @return
     */
    MethodLevelScopeEnum scope() default MethodLevelScopeEnum.GLOBAL;
    
    /**
     * 单位时间长段内最大请求量
     * @return
     */
    int rate() default 10;
    
    /**
     * 限制时间长度
     * @return
     */
    int interval() default 1;
    
    TimeUnit unit() default TimeUnit.SECONDS;
    
    /**
     * 限流后的提示信息
     * @return
     */
    String message() default "请求次数过多，请稍后再试";
}
