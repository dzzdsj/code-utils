package com.dzzdsj.demo.codeutils.Spring.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向：Redirect,客服端总共发起两次请求，地址栏变化，数据不共享
 * 转发：Forward，客服端总共发起一次请求，地址栏不变，转发页面和转发到的页面可以共享request里面的数据
 */
@Controller
public class RedirectAndForwardDemo {
    @GetMapping("/redirectUrl")
    public String redirectUrl(){
        return "redirect:/mvc9?id=7";
//        return "redirect:http://127.0.0.1:8080/mvc9?id=7";
//        return "redirect:http://www.baidu.com";
    }
    @GetMapping("/forwardUrl")
    public String forwardUrl(HttpServletRequest request, HttpServletResponse response){
        return "forward:/mvc9?id=7";
    }
}
