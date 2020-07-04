package com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/rest")
public class RestTemplateRequest {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public void test() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Map<String, String> mapValue = AppCredentials.generateAppCredentials(null, "20171204174888", "396d1c9b6f7038fabe521ea8e38963ff", "SM3", "/dataService/tN779OOrmliHUYh658n20EHikPvfZpVZGIYi/");
        mapValue.forEach((key, value) -> headers.add(key, value));
        JSONObject obj = new JSONObject();
        obj.put("authMode", "S030");
        HttpEntity<JSONObject> entity = new HttpEntity(obj, headers);
        String urlPrefix = "http://gateway.joinzone.com";
        String url = urlPrefix + "/dataService/tN779OOrmliHUYh658n20EHikPvfZpVZGIYi/";
        ResponseEntity<String> ret = this.restTemplate.postForEntity(url, entity, String.class);
        JSONObject objRet = JSONObject.parseObject(ret.getBody());
    }


    public static void main(String[] args) {
        String url = "https://httpbin.org/ip";


    }
}
