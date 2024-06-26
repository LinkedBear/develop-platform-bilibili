package com.linkedbear.platform.core.component.strategy;

/**
 * 策略模式的根接口
 * @param <T>
 * @param <R>
 */
public interface Strategy<T, R> {
    
    /**
     * 判断当前策略是否可以处理入参数据
     * @param value
     * @param param
     * @return
     */
    boolean support(T value, Object param);
    
    /**
     * 接收入参数据并处理得到返回结果
     * @param value
     * @return
     */
    R invoke(T value);
}
