package com.linkedbear.platform.core.component.limit;

import com.linkedbear.platform.core.security.user.PlatformUserContext;

import java.lang.reflect.Method;

/**
 * 切面控制级别
 * @author LinkedBear
 */
public enum MethodLevelScopeEnum {
    GLOBAL,
    DEPARTMENT,
    USER;
    
    /**
     * 根据方法名和切面控制级别 生成对应缓存的key
     * @param method
     * @param scope
     * @return
     */
    public static String getScopeKey(Method method, MethodLevelScopeEnum scope) {
        String methodName = method.getDeclaringClass().getName() + "." + method.getName();
        return switch (scope) {
            case USER -> methodName + "." + PlatformUserContext.currentUser().getId();
            case DEPARTMENT -> methodName + "." + PlatformUserContext.currentUser().getOrgId();
            default -> methodName;
        };
    }
}
