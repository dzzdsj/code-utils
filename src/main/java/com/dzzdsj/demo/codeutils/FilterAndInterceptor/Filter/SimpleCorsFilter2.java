package com.dzzdsj.demo.codeutils.FilterAndInterceptor.Filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述: 跨域 CORS Filter，简单版本
 */

public class SimpleCorsFilter2 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type, accept, origin, X-Toon-User-ID, X-Toon-User-Token, X-Toon-User-Agent,sessionId");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
