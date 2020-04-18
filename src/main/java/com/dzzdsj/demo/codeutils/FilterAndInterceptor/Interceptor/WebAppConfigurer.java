package com.dzzdsj.demo.codeutils.FilterAndInterceptor.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * 取代过时的WebMvcConfigurerAdapter。    或者   implements WebMvcConfigurer
 */

@Configuration
public class WebAppConfigurer extends WebMvcConfigurationSupport  {

//    @Bean
//    public SessionInterceptor sessionInterceptor() {
//        return new SessionInterceptor();
//    }
//
//    @Bean
//    public AdminInterceptor adminInterceptor() {
//        return new AdminInterceptor();
//    }
    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(sessionInterceptor()).addPathPatterns("/certificate/**", "/exam/**", "/enterprise/**", "/institution/**", "/regulators/**", "/user/**", "/message/send", "/message/getMessageTemplate", "/excel/**", "/password/modify");
//        registry.addInterceptor(adminInterceptor()).addPathPatterns("/institution/**", "/regulators/**");
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/certificate/**", "/exam/**", "/enterprise/**", "/institution/**", "/regulators/**", "/user/**", "/message/send", "/message/getMessageTemplate", "/excel/**", "/password/modify");
        registry.addInterceptor(adminInterceptor).addPathPatterns("/institution/**", "/regulators/**");
        super.addInterceptors(registry);
    }
// TODO: 2020/4/15
/**处理@Responbody 返回中文字符串乱码,这样返回String可以，但会有问题，直接返回对象时序列化会报错
 * 另一种办法是在接口上加注解，但限制了请求的类型(produces = "text/plain;charset=UTF-8")
 * @GetMapping(value = "/stringRedis",produces = "text/plain;charset=UTF-8")
 * */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        converters.add(responseBodyConverter());
//    }
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        StringHttpMessageConverter converter = new StringHttpMessageConverter();
//        converter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", Charset.forName("UTF-8"))));
//        return converter;
//    }
}
