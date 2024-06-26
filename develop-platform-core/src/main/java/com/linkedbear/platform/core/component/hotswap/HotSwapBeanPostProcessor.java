package com.linkedbear.platform.core.component.hotswap;

import com.linkedbear.platform.core.util.spring.ApplicationContextHolder;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.util.ClassUtils;

import java.util.Set;

/**
 * 支持对象热切换的代理对象封装
 * @author LinkedBear
 */
public class HotSwapBeanPostProcessor implements BeanPostProcessor {
    
    private Set<Class<?>> swapSupportTypes;
    
    public HotSwapBeanPostProcessor(Set<Class<?>> swapSupportTypes) {
        this.swapSupportTypes = swapSupportTypes;
    }
    
    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        Class<?> clazz = AopUtils.isAopProxy(bean) ? AopUtils.getTargetClass(bean) : bean.getClass();
        if (!swapSupportTypes.contains(clazz)) {
            return bean;
        }
        if (ApplicationContextHolder.getBeanFactory().getBeanDefinition(beanName).isPrimary()) {
            ProxyFactory proxyFactory = new ProxyFactory();
            proxyFactory.setProxyTargetClass(true);
            proxyFactory.setTargetSource(TargetSourceContainer.getTargetSource(bean));
            return proxyFactory.getProxy(ClassUtils.getDefaultClassLoader());
        }
        return bean;
    }
}
