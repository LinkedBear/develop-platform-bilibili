package com.linkedbear.platform.core.security.user;

import com.linkedbear.platform.core.util.spring.ApplicationContextHolder;

/**
 * 用于获取当前登录人
 * @author LinkedBear
 */
public interface PlatformUserContext {

    PlatformUser getCurrentUser();
    
    static PlatformUser currentUser() {
        return ApplicationContextHolder.getBean(PlatformUserContext.class).getCurrentUser();
    }
}
