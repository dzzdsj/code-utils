package com.dzzdsj.demo.codeutils.FastJsonDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.dzzdsj.demo.codeutils.FastJsonDemo.entity.Simple;
import com.dzzdsj.demo.codeutils.FastJsonDemo.entity.SimpleObject;

/**
 * json字符串、JSONObject、java对象互相转换
 */
public class TransformFormat {
    public static void main(String[] args) {
        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setId(100L);
        simpleObject.setName("天天");
        System.out.println(simpleObject);
        //java对象转json字符串
        String jsonStr = JSONObject.toJSONString(simpleObject);
        System.out.println(jsonStr);
        //json字符串转JSONObject
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        System.out.println(jsonObject);
        //json字符串转java对象1
        SimpleObject object = JSON.parseObject(jsonStr, SimpleObject.class);
        System.out.println(object);
        //json字符串转java对象2(需要带引号的字符串，restTemplate接收时用String.class，不能直接用JSONObject)
        SimpleObject object2 = JSON.parseObject(jsonStr, new TypeReference<SimpleObject>(){});
        System.out.println(object2);
        Simple object3 = JSON.parseObject(jsonStr, new TypeReference<Simple>(){});
        System.out.println(object3);
        //不一定要属性一一对应，构造需要的属性转换即可
        Simple simple = JSON.parseObject(jsonStr, Simple.class);
        System.out.println(simple);
    }
}
