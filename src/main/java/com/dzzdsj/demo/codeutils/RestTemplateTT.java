package com.dzzdsj.demo.codeutils;

import com.alibaba.fastjson.JSONObject;
import com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo.AppCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tt")
public class RestTemplateTT {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dd")
    public void test() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Map<String, String> mapValue = new HashMap<>();
        mapValue.put("sessionId", "13107317-7833-4d28-b992-53d19e010c9b");
//        mapValue.forEach((key, value) -> headers.add(key, value));
        headers.add("sessionId", "13107317-7833-4d28-b992-53d19e010c9b");
        JSONObject obj = new JSONObject();
        HttpEntity<JSONObject> entity = new HttpEntity(null, headers);
        String url = "https://syother.efzhou.com/fuzhou-house-new-service/api/preview/202017444890";
        ResponseEntity<String> ret = this.restTemplate.getForEntity(url,String.class,entity);
        JSONObject objRet = JSONObject.parseObject(ret.getBody());
    }


    public static void main(String[] args) {
        String url = "https://httpbin.org/ip";


    }
}
