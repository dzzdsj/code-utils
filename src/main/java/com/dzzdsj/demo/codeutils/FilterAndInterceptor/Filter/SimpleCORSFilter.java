package com.dzzdsj.demo.codeutils.FilterAndInterceptor.Filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述: 跨域 CORS Filter
 */

@Component
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        })
public class SimpleCORSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        //允许所有请求域
        response.setHeader("Access-Control-Allow-Origin", "*");
        //允许的请求方法
        response.setHeader("Access-Control-Allow-Methods", "POST, GET,OPTIONS");
        //预检时效
        response.setHeader("Access-Control-Max-Age", "3600");
        //允许的header
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type, accept, origin, X-Toon-User-ID, X-Toon-User-Token, X-Toon-User-Agent,sessionId");
        //执行下一个filter，如果没有就执行请求
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
