package com.linkedbear.platform.core.enhancer.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.WebUtils;

import java.util.HashMap;
import java.util.Map;

import static com.linkedbear.platform.core.constant.PlatformConstants.*;

/**
 * 常见异常的统一处理
 * @author LinkedBear
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(PlatformException.class)
    public String resolvePlatformException(PlatformException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        Map<String, Object> map = new HashMap<>();
        map.put(EXCEPTION_MESSAGE, e.getMessage());
        request.setAttribute(ERROR_DATA, map);
        request.setAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return "forward:/error";
    }
    
    @ExceptionHandler(Exception.class)
    public String resolveException(Exception e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        Map<String, Object> map = new HashMap<>();
        map.put(ERROR_MESSAGE, "对不起，程序出现异常，请稍后再试");
        map.put(EXCEPTION_MESSAGE, e.getMessage());
        request.setAttribute(ERROR_DATA, map);
        request.setAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return "forward:/error"; // 不破坏SpringWebMvc的内容协商
    }
}
