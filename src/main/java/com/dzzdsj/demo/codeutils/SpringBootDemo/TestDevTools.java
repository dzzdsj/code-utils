package com.dzzdsj.demo.codeutils.SpringBootDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestDevTools {
    @RequestMapping("/test4")
    public void testDevTools() {
        System.out.println("ok" + new Date());
    }
}
