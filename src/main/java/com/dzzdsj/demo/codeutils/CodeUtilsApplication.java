package com.dzzdsj.demo.codeutils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dzzdsj.demo.codeutils.SpringBootDemo.Transactional.mapper")
public class CodeUtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeUtilsApplication.class, args);
    }

}
