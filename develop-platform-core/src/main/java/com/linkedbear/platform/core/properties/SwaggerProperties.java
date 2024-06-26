package com.linkedbear.platform.core.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "platform.swagger")
public class SwaggerProperties {
    
    /**
     * Swagger文档的标题
     */
    private String title = "application";
    
    /**
     * Swagger文档的描述信息
     */
    private String description = "develop-platform application";
    
    /**
     * Swagger文档展示的版本号
     */
    private String version = "1.0.0";
    
    /**
     * Swagger文档的接口分组，以根包作为划分依据
     */
    private List<GroupInfo> groups = new ArrayList<>();
    
    @Data
    public static class GroupInfo {
        private String name;
        private String view;
        private String basePackage;
    }
}
