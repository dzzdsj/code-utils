package com.dzzdsj.demo.codeutils.SpringBootDemo.Jackson;

import com.dzzdsj.demo.codeutils.SpringBootDemo.Transactional.entity.TestUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot 默认使用jackson
 * 树模型和数据绑定都是基于流式操作完成的，即通过JsonParser 类解析JSON ，形成JsonToken流，
 */
@Controller
public class TestJackson {
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/defaultJackson")
    public @ResponseBody
    Map defaultJackson() {
        Map<String, Date> map = new HashMap<>();
        map.put("now", new Date());
        return map;
    }

    @GetMapping("/defaultJackson1")
    public @ResponseBody
    Map defaultJackson1() {
        Map<String, Date> map = new HashMap<>();
        map.put("now", new Date());
        return map;
    }
    /**1树模型*/
    /**
     * readTree json树遍历形式
     */
    @GetMapping("/readJson1")
    public @ResponseBody
    String readJson1() {
        String json = "{ \"name\":\"lijz\",\"id\":10}";
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            String name = jsonNode.get("name").asText();//获取当前节点子节点并转为text
            Integer id = jsonNode.get("id").asInt();
            return "name:" + name + "  " + "id:" + id;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**2数据绑定*/
    /**
     * readValue 反序列化
     */
    @GetMapping("/readJson2")
    public @ResponseBody
    String readJson2() {
        String json = "{ \"name\":\"lijz\",\"id\":10}";
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            TestUser testUser = objectMapper.readValue(json, TestUser.class);
            return "name:" + testUser.getName() + "  " + "id:" + testUser.getId();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * writeValueAsString 序列化
     */
    @GetMapping("/readJson3")
    public @ResponseBody
    String readJson3() {
        TestUser testUser = new TestUser();
        testUser.setId(3);
        testUser.setName("tom");
        testUser.setPhone("12345");
        try {
            return objectMapper.writeValueAsString(testUser);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**3jsonToken流操作*/
    // TODO: 2020/4/13  待验证
}
