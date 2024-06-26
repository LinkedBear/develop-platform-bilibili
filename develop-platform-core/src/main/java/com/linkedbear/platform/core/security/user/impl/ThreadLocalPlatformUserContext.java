package com.linkedbear.platform.core.security.user.impl;

import cn.hutool.core.util.ObjectUtil;
import com.linkedbear.platform.core.security.user.PlatformUser;
import com.linkedbear.platform.core.security.user.PlatformUserContext;

/**
 * 基于线程的全局当前登录人获取
 * @author LinkedBear
 */
public class ThreadLocalPlatformUserContext implements PlatformUserContext {
    
    private static final ThreadLocal<PlatformUser> USER_THREAD_LOCAL = new InheritableThreadLocal<>();
    
    public static PlatformUser currentUser() {
        return USER_THREAD_LOCAL.get();
    }
    
    @Override
    public PlatformUser getCurrentUser() {
        return ObjectUtil.defaultIfNull(USER_THREAD_LOCAL.get(), PlatformUser.getAnonymousUser());
    }
    
    public void setCurrentUser(PlatformUser user) {
        USER_THREAD_LOCAL.set(user);
    }
    
    public void removeCurrentUser() {
        USER_THREAD_LOCAL.remove();
    }
}
