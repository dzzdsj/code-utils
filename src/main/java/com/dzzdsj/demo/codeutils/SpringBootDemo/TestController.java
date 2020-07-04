package com.dzzdsj.demo.codeutils.SpringBootDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 演示输出执行servlet的线程名
 */
@RestController
public class TestController {
    @GetMapping("/echo")
    public void test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Thread currentThread = Thread.currentThread();
        // 获取当前线程的线程名称
        String currentThreadName = currentThread.getName();
        response.setContentType("text/plain");
        try (PrintWriter pwr = response.getWriter()) {
            // 输出处理当前请求的线程的名称
            pwr.printf("This request was handled by thread:%s%n", currentThreadName);
            System.out.println(currentThread.getState());
            pwr.flush();
        }
    }
}
