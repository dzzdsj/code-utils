//package com.dzzdsj.demo.codeutils.FilterAndInterceptor.Interceptor;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class WebAppConfigurerOld extends WebMvcConfigurerAdapter {
//
//    @Bean
//    public SessionInterceptor sessionInterceptor() {
//        return new SessionInterceptor();
//    }
//
//    @Bean
//    public AdminInterceptor adminInterceptor() {
//        return new AdminInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 多个拦截器组成一个拦截器链
//        // addPathPatterns 用于添加拦截规则
//        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(sessionInterceptor()).addPathPatterns("/certificate/**", "/exam/**", "/enterprise/**", "/institution/**", "/regulators/**", "/user/**", "/message/send", "/message/getMessageTemplate", "/excel/**", "/password/modify");
//        registry.addInterceptor(adminInterceptor()).addPathPatterns("/institution/**", "/regulators/**");
//        super.addInterceptors(registry);
//    }
//}
