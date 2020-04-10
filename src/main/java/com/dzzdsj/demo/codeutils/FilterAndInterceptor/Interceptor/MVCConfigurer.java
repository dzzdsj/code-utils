package com.dzzdsj.demo.codeutils.FilterAndInterceptor.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局定制化Spring Boot 的MVC 特性。开发者通过实现 WebMvcConfigurer 接口来配置应用的MVC全局特性
 */
@Configuration
public class MVCConfigurer implements WebMvcConfigurer {
    @Autowired
    private SessionInterceptor sessionInterceptor;
    /**拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/certificate/**", "/exam/**", "/enterprise/**", "/institution/**", "/regulators/**", "/user/**", "/message/send", "/message/getMessageTemplate", "/excel/**", "/password/modify");
    }
    /**跨域访问配置*/
    /**出于安全的考虑，浏览器会禁止AJAX 访问不同域的地址。W3C 的CORS 规范（ Cross-origin
     resource sharing ）允许实现跨域访问，并被现在大多数浏览器支持*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**");//允许所有跨域
        //配置允许跨域访问的细节
        registry.addMapping("/api/**")
                .allowedOrigins("http://domain.com")
                .allowedMethods("GET","POST")
                .allowedHeaders("sessionId");
    }
    /**格式化*/
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //DateFormatter 类实现将字符串转为日期类型java.util.Data
//        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
        //todo 未试验成功
    }
    /**URI到视图的映射*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //重定向请求
        registry.addRedirectViewController("/a/**","/b");
    }
    //other interface
}
