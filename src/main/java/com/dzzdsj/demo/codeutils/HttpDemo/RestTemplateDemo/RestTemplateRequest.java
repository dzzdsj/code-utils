package com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateRequest {
    @Autowired
    private RestTemplate restTemplate;




    public static void main(String[] args) {
        String url = "https://httpbin.org/ip";





    }
}
