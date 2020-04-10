package com.dzzdsj.demo.codeutils.Spring.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向：Redirect,客服端总共发起两次请求，地址栏变化，数据不共享
 * 转发：Forward，客服端总共发起一次请求，地址栏不变，转发页面和转发到的页面可以共享request里面的数据
 */
@RestController
public class RestRedirectAndForwardDemo {
    @GetMapping("/restRedirectUrl")
    public void restRedirectUrl(HttpServletRequest request, HttpServletResponse response){
        try {
//            response.sendRedirect("/mvc9?id=7");
//            response.sendRedirect("http://127.0.0.1:8080/mvc9?id=7");
            response.sendRedirect("http://www.baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/restForwardUrl")
    public void restForwardUrl(HttpServletRequest request, HttpServletResponse response){
        try {
//            request.getRequestDispatcher("new.jsp").forward(request, response);
            request.getRequestDispatcher("/mvc9?id=7").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
