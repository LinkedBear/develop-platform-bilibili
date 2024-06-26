package com.linkedbear.platform.core.autoconfigure;

import com.linkedbear.platform.core.util.reflect.ReflectUtils;
import com.linkedbear.platform.core.util.spring.ApplicationContextHolder;
import com.linkedbear.platform.core.util.spring.EnvironmentHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.beans.Introspector;
import java.util.Set;

public class ContextHolderRunListener implements SpringApplicationRunListener {
    
    private static SpringApplication springApplication;
    
    public ContextHolderRunListener(SpringApplication application, String[] args) {
        Set<Class<?>> primarySource = (Set<Class<?>>) ReflectUtils.getFieldValue(application, "primarySources");
        for (Class<?> clazz : primarySource) {
            if (clazz.isAnnotationPresent(SpringBootApplication.class)) {
                ContextHolderRunListener.springApplication = application;
                return;
            }
        }
    }
    
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        // 兼容SpringCloud应用多次创建SpringApplication引发ctx被覆盖的情况
        if (context instanceof ServletWebServerApplicationContext) {
            ApplicationContextHolder.setContext(context);
            EnvironmentHolder.setEnvironment(context.getEnvironment());
            return;
        }
        // JUnit
        Set<Class<?>> primarySources = (Set<Class<?>>) ReflectUtils.getFieldValue(springApplication, "primarySources");
        for (Class<?> primarySource : primarySources) {
            if (primarySource.getSimpleName().equals("BootstrapImportSelectorConfiguration")) {
                continue;
            }
            if (context.containsBeanDefinition(Introspector.decapitalize(primarySource.getSimpleName()))) {
                ApplicationContextHolder.setContext(context);
                EnvironmentHolder.setEnvironment(context.getEnvironment());
                return;
            }
        }
    }
}
