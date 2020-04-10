//package com.dzzdsj.demo.codeutils.SpringBootDemo.GlobalErrorHandle;
//
//import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
//import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * 在Spring Boot 中，由controller中抛出的异常默认交给了／error 来处理，应用程序可以将／error 映射
// * 到一个特定的Controller 中处理来代替Spring Boot 的默认实现， 应用可以继承AbstractErrorController来统一处理系统的各种异常。
// */
//// TODO: 2020/4/9 待验证及测试
//@Controller
//public class ErrorController extends AbstractErrorController {
//    public ErrorController(){
//        super(new DefaultErrorAttributes());
//    }
//    @RequestMapping("/error")
//    @Override
//    public String getErrorPath() {
//        return null;
//    }
//}
