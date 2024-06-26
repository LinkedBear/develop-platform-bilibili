package com.linkedbear.platform.core.component.limit.container;

import java.util.concurrent.TimeUnit;

/**
 * 放置带延时失效的缓存容器，用于支持限流功能
 * @author LinkedBear
 */
public interface LimitCacheContainer {
    
    /**
     * 获取指定key在缓存容器中的计数
     * @param key
     * @return
     */
    int getCount(String key);
    
    /**
     * 添加一次新的计数，并设置过期时间
     * @param key
     * @param expire
     * @param unit
     * @return
     */
    int addCount(String key, int expire, TimeUnit unit);
}
