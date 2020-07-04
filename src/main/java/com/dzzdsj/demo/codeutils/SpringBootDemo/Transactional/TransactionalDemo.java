package com.dzzdsj.demo.codeutils.SpringBootDemo.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionalDemo {
    @Autowired
    private TransactionalService transactionalService;

    @GetMapping("/addTestUser")
    public void addUser() throws Exception {
        try {
            transactionalService.addUser();
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("fail");
        }
    }
}
