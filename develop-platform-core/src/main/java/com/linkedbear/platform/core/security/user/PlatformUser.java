package com.linkedbear.platform.core.security.user;

import cn.hutool.json.JSONUtil;
import lombok.Data;

import java.io.Serializable;
import java.security.Principal;

/**
 * platform用户基础信息模型
 * @author LinkedBear
 */
@Data
public class PlatformUser implements Principal, Serializable {
    private static final long serialVersionUID = 9114401413929747302L;
    
    protected String id;
    
    protected String username;
    
    protected String name;
    
    private String orgId;
    
    private String jobId;
    
    private String parentOrgId;
    
    private String roleId;
    
    private static final PlatformUser ANONYMOUS_USER = new PlatformUser();
    
    static {
        ANONYMOUS_USER.setId("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        ANONYMOUS_USER.setUsername("anonymous");
        ANONYMOUS_USER.setName("匿名用户");
        ANONYMOUS_USER.setOrgId("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        ANONYMOUS_USER.setJobId("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        ANONYMOUS_USER.setRoleId("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
    }
    
    public static PlatformUser getAnonymousUser() {
        return ANONYMOUS_USER;
    }
    
    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
