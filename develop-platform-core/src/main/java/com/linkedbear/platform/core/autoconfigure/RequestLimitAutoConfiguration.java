package com.linkedbear.platform.core.autoconfigure;

import com.linkedbear.platform.core.component.limit.aspect.RequestLimitAspect;
import com.linkedbear.platform.core.component.limit.container.HutoolLimitCacheContainer;
import com.linkedbear.platform.core.component.limit.container.LimitCacheContainer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

/**
 * 请求限流（Controller、Service等）
 * @author LinkedBear
 */
@AutoConfiguration
@ConditionalOnBean(RequestLimitAutoConfiguration.Marker.class)
public class RequestLimitAutoConfiguration {
    
    /**
     * 默认使用hutool-cache的进程级过期缓存容器
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnMissingClass("org.springframework.data.redis.connection.RedisConnectionFactory")
    public LimitCacheContainer limitCacheContainer() {
        return new HutoolLimitCacheContainer(Duration.ofMinutes(1));
    }
    
    @Bean
    public RequestLimitAspect requestLimitAspect(LimitCacheContainer limitCacheContainer) {
        return new RequestLimitAspect(limitCacheContainer);
    }
    
    public static class Marker {}
}
