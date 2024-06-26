package com.linkedbear.platform.core.util.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ApplicationContextHolder {
    
    private static boolean locked = false;
    private static ConfigurableApplicationContext ctx;
    private static DefaultListableBeanFactory beanFactory;
    
    public static synchronized void setContext(ConfigurableApplicationContext ctx) {
        if (locked) {
            return;
        }
        ApplicationContextHolder.ctx = ctx;
        ApplicationContextHolder.beanFactory = (DefaultListableBeanFactory) ctx.getBeanFactory();
        locked = true;
    }
    
    public static <T> T getBean(String beanName) {
        return (T) ctx.getBean(beanName);
    }
    
    public static <T> T getBean(Class<T> requiredType) {
        return ctx.getBean(requiredType);
    }
    
    public static <T> List<T> getBeans(Class<T> requiredType) {
        return new ArrayList<>(ctx.getBeansOfType(requiredType).values());
    }
    
    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
    
    public static DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
