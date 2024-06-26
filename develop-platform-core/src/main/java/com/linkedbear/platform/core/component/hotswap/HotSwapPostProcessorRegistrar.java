package com.linkedbear.platform.core.component.hotswap;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/**
 * 支持bean的动态热切换
 * @author LinkedBear
 */
public class HotSwapPostProcessorRegistrar implements ImportBeanDefinitionRegistrar {
    
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, @NonNull BeanDefinitionRegistry registry) {
        final Map<String, Object> attributes = metadata.getAnnotationAttributes(EnableBeanHotSwap.class.getName());
        Class<?>[] hotSwapTypes = (Class<?>[]) attributes.get("value");
        
        if (ArrayUtil.isNotEmpty(hotSwapTypes)) {
            registry.registerBeanDefinition("hotSwapBeanPostProcessor",
                    BeanDefinitionBuilder.rootBeanDefinition(HotSwapBeanPostProcessor.class)
                            .addConstructorArgValue(new HashSet<>(Arrays.asList(hotSwapTypes))).getBeanDefinition());
        }
    }
}
