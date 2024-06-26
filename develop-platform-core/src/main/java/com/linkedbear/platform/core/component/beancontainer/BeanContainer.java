package com.linkedbear.platform.core.component.beancontainer;

import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * 存放多个相同类型bean的容器介质
 * @author LinkedBear
 * @param <T>
 */
public class BeanContainer<T> {
    
    private ApplicationContext ctx;
    private Class<T> clazz;
    
    private Map<String, T> beans;
    private String[] beanNames;
    
    private int index = 0;
    
    /**
     * 走Map，代表是立即初始化
     * @param beans
     */
    public BeanContainer(Map<String, T> beans) {
        this.initBeans(beans);
        this.clazz = (Class<T>) this.get().getClass();
    }
    
    /**
     * 走IOC容器，代表是延迟初始化
     * @param ctx
     * @param clazz
     */
    public BeanContainer(ApplicationContext ctx, Class<T> clazz) {
        this.ctx = ctx;
        this.clazz = clazz;
    }
    
    public void initBeans(Map<String, T> beans) {
        Assert.notEmpty(beans, "beans must not be empty!");
        this.beans = beans;
        this.beanNames = new String[beans.size()];
        int beanIndex = 0;
        for (Map.Entry<String, T> entry : beans.entrySet()) {
            beanNames[beanIndex++] = entry.getKey();
        }
    }
    
    /**
     * 走IOC容器时，需要指定当前方法为init-method
     */
    public void init() {
        this.initBeans(ctx.getBeansOfType(clazz));
    }
    
    public T get() {
        return beans.get(beanNames[index % beanNames.length]);
    }
    
    public synchronized void next() {
        index++;
    }
}
