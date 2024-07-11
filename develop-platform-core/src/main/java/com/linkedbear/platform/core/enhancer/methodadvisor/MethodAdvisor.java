package com.linkedbear.platform.core.enhancer.methodadvisor;

public interface MethodAdvisor<T> {
    
    default boolean before() {
        return true;
    }
    
    default void after(Object returnValue) {
    
    }
}
