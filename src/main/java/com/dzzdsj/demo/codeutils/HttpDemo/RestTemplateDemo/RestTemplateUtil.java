//package com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo;
//
//import com.alibaba.fastjson.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Map;
//
//
//public class RestTemplateUtil {
//    private static final Logger log = LoggerFactory.getLogger(RestTemplateUtil.class);
//    /**
//     * 统一post请求方法
//     * @param headers 请求头
//     * @param map 请求入参
//     * @param url
//     * @return
//     */
//    public static JSONObject sendFormDataPostRequest(HttpHeaders headers,MultiValueMap<String, String> map,String url) {
//        RestTemplate restTemplate = new RestTemplate();
//        long currTime = System.currentTimeMillis();
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(
//                map, headers);
//        //发送请求，设置请求返回数据格式为String
//        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, request, JSONObject.class);
//        log.info("请求耗时："+(System.currentTimeMillis()-currTime));
//        return responseEntity.getBody();
//    }
//
//    /**
//     * 统一post请求方法
//     * @param headers 请求头
//     * @param jsonParam 请求入参
//     * @param url
//     * @return
//     */
//    public static JSONObject sendJsonPostRequest(HttpHeaders headers,JSONObject jsonParam,String url) {
//        RestTemplate restTemplate = new RestTemplate();
//        long currTime = System.currentTimeMillis();
//        HttpEntity<String> request = new HttpEntity<String>(
//                jsonParam.toString(), headers);
//        //发送请求，设置请求返回数据格式为String
//        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, request, JSONObject.class);
//        log.info("请求耗时："+(System.currentTimeMillis()-currTime));
//        return responseEntity.getBody();
//    }
//
//    public static JSONObject sendJsonGetRequest(String url, Map<String, ?> uriVariables) {
//        RestTemplate restTemplate = new RestTemplate();
//        long currTime = System.currentTimeMillis();
//        //发送请求，设置请求返回数据格式为String
//        ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(url, JSONObject.class);
//        log.info("请求耗时："+(System.currentTimeMillis()-currTime));
//        return responseEntity.getBody();
//    }
//}
