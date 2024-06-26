package com.linkedbear.platform.core.util.result;

/**
 * 响应码定义
 * @author LinkedBear
 */
public enum ResultCodeEnum {
    OK(0, "操作成功！"),
    
    CLIENT_ERROR(10000, "客户端出现异常！"),
    USER_ERROR(11000, "用户异常！"),
    NO_AUTHENTICATE(11100, "认证失败！"),
    USERNAME_PASSWORD_ERROR(11110, "用户名或密码错误！"),
    USER_STATUS_LOCKED(11130, "用户账号被锁定，不允许登录！"),
    NO_LOGIN(11111, "用户未登录！"),
    TOKEN_EXPIRE(11112, "登录身份已过期！"),
    TOKEN_ERROR(11119, "登录身份失效！"),
    REFRESH_EXPIRE(11122, "登录身份已过期，请重新登录！"),
    REFRESH_ERROR(11129, "登录身份失效，请重新登录！"),
    NO_AUTHORIZE(11300, "权限不足！"),
    VALIDATE_ERROR(18000, "数据格式错误！"),
    REQUEST_FREQUENT(19000, "请求过于频繁，请5秒后重试！"),
    
    NOT_FOUNT(40000, "请求的资源不存在！"),
    TOO_MANY_REQUESTS(44000, "请求过于频繁，请稍后重试！"),
    
    SERVER_ERROR(50000, "操作失败！"),
    NO_DATA(51000, "数据不存在！"),
    NOT_IMPLEMENTED(52000, "功能未实现/未开启！"),
    REPEATED_REQUESTS(59000, "操作过快，请稍后重试！"),
    ;
    
    
    public Integer code;
    public String msg;
    
    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public ResultVO result() {
        return new ResultVO(this);
    }
    
    public ResultVO result(Object obj) {
        return new ResultVO(obj, this);
    }
}
