package com.linkedbear.platform.core.util.http;

import cn.hutool.json.JSONUtil;
import com.linkedbear.platform.core.util.result.ResultVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;

/**
 * http相关的工具类
 * @author LinkedBear
 */
public abstract class HttpUtils {
    
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.notNull(attrs, "获取Servlet API失败！");
        return attrs.getRequest();
    }
    
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.notNull(attrs, "获取Servlet API失败！");
        return attrs.getResponse();
    }
    
    public static String getRequestIp() {
        HttpServletRequest request = getRequest();
        return request != null ? request.getRemoteHost() : "127.0.0.1";
    }
    
    /**
     * 向response中写入json数据
     * @param response
     * @param vo
     * @throws IOException
     */
    public static void writeJson(HttpServletResponse response, ResultVO vo) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSONUtil.toJsonStr(vo));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
