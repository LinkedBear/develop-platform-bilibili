package com.linkedbear.platform.core.component.beancontainer;

import com.linkedbear.platform.core.component.log.writer.BusinessLogWriter;
import com.linkedbear.platform.core.util.spring.ApplicationContextHolder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

// 更推荐选择ImportBeanDefinitionRegistrar，ImportBeanDefinitionRegistrar的执行时机相对晚一些
public class BeanContainerRegistrar implements ImportBeanDefinitionRegistrar, BeanDefinitionRegistryPostProcessor {
    
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition("businessLogWriterContainer",
                BeanDefinitionBuilder.rootBeanDefinition(BeanContainer.class)
                        .addConstructorArgValue(ApplicationContextHolder.getApplicationContext())
                        .addConstructorArgValue(BusinessLogWriter.class).setInitMethodName("init").getBeanDefinition());
    }
    
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        registry.registerBeanDefinition("businessLogWriterContainer",
                BeanDefinitionBuilder.rootBeanDefinition(BeanContainer.class)
                        .addConstructorArgValue(ApplicationContextHolder.getApplicationContext())
                        .addConstructorArgValue(BusinessLogWriter.class).setInitMethodName("init").getBeanDefinition());
    }
    
    /*
    @Bean(initMethod = "init")
    public BeanContainer businessLogWriterContainer() {
        return new BeanContainer(ApplicationContextHolder.getApplicationContext(), BusinessLogWriter.class);
    }
     */
}
