package com.linkedbear.platform.core.enhancer.methodadvisor;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MethodContext<T> {
    
    private T data;
    
    private Map<String, Object> ext;
    
    private MethodContext<T> old;
    
    public MethodContext() {
        this.ext = new HashMap<>();
    }
    
    public MethodContext(MethodContext<T> old) {
        this();
        this.old = old;
    }
    
    public MethodContext(T data) {
        this();
        this.data = data;
    }
    
    public MethodContext(T data, MethodContext<T> old) {
        this();
        this.data = data;
        this.old = old;
    }
    
    public static <E> MethodContext<E> getContext() {
        return MethodAdvisorAspect.getContext();
    }
}
