package com.linkedbear.platform.core.enhancer.methodadvisor;

public interface MethodAdvisor {
    
    default boolean before() {
        return true;
    }
    
    default void after() {
    
    }
}
