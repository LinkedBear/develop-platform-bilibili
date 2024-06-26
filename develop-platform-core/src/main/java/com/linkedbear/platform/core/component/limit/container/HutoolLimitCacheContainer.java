package com.linkedbear.platform.core.component.limit.container;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * 基于Hutool-cache的过期缓存容器
 * @author LinkedBear
 */
public class HutoolLimitCacheContainer implements LimitCacheContainer {
    
    private final TimedCache<String, Integer> cache;
    
    public HutoolLimitCacheContainer(Duration duration) {
        cache = CacheUtil.newTimedCache(duration.toMillis());
    }
    
    @Override
    public int getCount(String key) {
        return cache.get(key, () -> 0);
    }
    
    @Override
    public int addCount(String key, int expire, TimeUnit unit) {
        Integer count = cache.get(key, () -> 0);
        cache.put(key, ++count, unit.toMillis(expire));
        return count;
    }
}
