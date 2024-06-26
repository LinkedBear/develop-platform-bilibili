package com.linkedbear.platform.core.autoconfigure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 整合develop-platform-core需要默认修改的配置
 * @author LinkedBear
 */
public class DefaultPropertiesEnvironmentPostProcessor implements EnvironmentPostProcessor {
    
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Map<String, Object> source = new HashMap<>();
        source.put("spring.main.banner-mode", "off");
        MapPropertySource propertySource = new MapPropertySource("develop-platform-propertysource", source);
        environment.getPropertySources().addLast(propertySource);
    }
}
