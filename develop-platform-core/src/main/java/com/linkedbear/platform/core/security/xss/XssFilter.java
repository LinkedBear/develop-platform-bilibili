package com.linkedbear.platform.core.security.xss;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;
import java.util.List;

/**
 * 防XSS攻击过滤器
 * @author LinkedBear
 */
public class XssFilter implements Filter {
    
    private List<String> excludes = null;
    
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String servletPath = httpServletRequest.getServletPath();
        
        if (excludes != null && excludes.stream().anyMatch(i -> antPathMatcher.match(i, servletPath))) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
        }
    }
    
    public List<String> getExcludes() {
        return excludes;
    }
    
    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }
}
