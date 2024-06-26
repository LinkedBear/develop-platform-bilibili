package com.linkedbear.platform.core.util.result;

import cn.hutool.core.util.IdUtil;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一响应结果模型类
 * @param <T>
 * @author LinkedBear
 */
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 7779160236865530179L;
    
    private T data;
    
    private Integer code;
    
    private String msg;
    
    // 额外可以扩展的数据域
    private Map<String, Object> ext;
    
    private String requestId;
    
    public T getData() {
        return data;
    }
    
    public ResultVO<T> setData(T data) {
        this.data = data;
        return this;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public Map<String, Object> getExt() {
        return ext;
    }
    
    public ResultVO setExt(Map<String, Object> ext) {
        this.ext = ext;
        return this;
    }
    
    public String getRequestId() {
        return requestId;
    }
    
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    
    /**
     * 生成唯一请求标识的id
     */
    public ResultVO generateRequestId() {
        this.requestId = IdUtil.getSnowflakeNextIdStr();
        return this;
    }
    
    /**
     * 支持链式添加额外数据
     * @param key
     * @param value
     * @return
     */
    public ResultVO addExt(String key, Object value) {
        Assert.notNull(key, "ResultVO extra key must be not null !");
        if (this.ext == null) {
            this.ext = new HashMap<>();
        }
        this.ext.put(key, value);
        return this;
    }
    
    public boolean isSuccess() {
        return ResultCodeEnum.OK.code.equals(code);
    }
    
    public ResultVO() {
    }
    
    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public ResultVO(ResultCodeEnum resultCode) {
        this.code = resultCode.code;
        this.msg = resultCode.msg;
    }
    
    public ResultVO(T data, ResultCodeEnum resultCode) {
        this.code = resultCode.code;
        this.msg = resultCode.msg;
        this.data = data;
    }
    
    public static ResultVO of(Integer code, String msg, Object data) {
        return new ResultVO(code, msg, data);
    }
    
    public static ResultVO success() {
        return success;
    }
    
    public static ResultVO success(Object data) {
        return new ResultVO(data, ResultCodeEnum.OK);
    }
    
    public static ResultVO error() {
        return error;
    }
    
    public static ResultVO error(String msg) {
        return new ResultVO(ResultCodeEnum.SERVER_ERROR.code, msg, null);
    }
    
    public static ResultVO error(Object data) {
        return new ResultVO(data, ResultCodeEnum.SERVER_ERROR);
    }
    
    public static ResultVO error(String msg, Object data) {
        return new ResultVO(ResultCodeEnum.SERVER_ERROR.code, msg, data);
    }
    
    public static ResultVO valueOf(boolean flag) {
        return flag ? ResultVO.success() : ResultVO.error();
    }
    
    public static ResultVO valueOf(boolean flag, String errMsg) {
        return flag ? ResultVO.success() : ResultVO.error(errMsg);
    }
    
    private static ResultVO success = new ResultVO(ResultCodeEnum.OK);
    private static ResultVO error = new ResultVO(ResultCodeEnum.SERVER_ERROR);
}
