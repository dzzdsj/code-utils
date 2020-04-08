package com.dzzdsj.demo.codeutils.Spring.SpringMVC;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**@Controller：默认是返回视图，如果返回字符串需要配合@ResponseBody注解*/
@Controller
public class SpringMVCDemo {
    @RequestMapping(path = "/mvc1",method = RequestMethod.GET)
    @ResponseBody
    public String test1(){
        return "returnHtml.html";
    }
    /**@ResponseBody 注解直接将返回的对象输出到客户端，如果是字符串， 则直接返回： 如果不
    是，则默认使用Jackson 序列化成JSON 字符串后输出*/
    @GetMapping(path = "/mvc2")
    @ResponseBody
    public TestEntity test2(){
        return new TestEntity();
    }
    /**@PathVariable  动态获取请求url路径中的参数*/
    @GetMapping(path = "/mvc3/{name}/blog/{id}")
    @ResponseBody
    public TestEntity test3(@PathVariable int id,@PathVariable String name){
//    public TestEntity test3(@PathVariable int id,@PathVariable("id") String name){  //不按名称相同，强制指定对应
        return new TestEntity(id, name);
    }
    /**属性consumes 意味着请求的HTTP头的Content-Type 媒体类型与consumes 的值匹配，才能调用此方法*/
    @GetMapping(value = "/mvc4",consumes = "application/json")
    @ResponseBody
    public String test4(){
        return "Ok";
    }
    /**produces 属性对应于HTTP 请求的Accept 字段， 只有匹配得上的方法才能被调用。*/
    @GetMapping(value = "/mvc5",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String test5(){
        return "Ok";
    }
    /**可以从请求参数中提取值来进一步确定调用的方法*/
//    @GetMapping(value = "/mvc6",params = "p!=6")  //不等于
//    @GetMapping(value = "/mvc6",params = "p=6")   //等于
    @GetMapping(value = "/mvc6",params = "p")   //存在
    @ResponseBody
    public String test6(){
        return "Ok";
    }
    /**可以从请求HTTP 头中提取值来进一步确定调用的方法*/
    @GetMapping(value = "/mvc7",headers = "p")   //存在
    @ResponseBody
    public String test7(){
        return "Ok";
    }
    /**@RequestParam 进一步对参数进行限定，是否必填，给默认值等*/
    @GetMapping(value = "/mvc8")
    @ResponseBody
    public String test8(@RequestParam(name = "id",required = true) int id,@RequestParam(name = "name",defaultValue = "ss") String name){
        return name;
    }
    /**可以将HTTP参数转为JavaBean 对象， HTTP 参数的名字对应到POJO 的属性名*/
    @GetMapping(value = "/mvc9")
    @ResponseBody
    public TestEntity test9(TestEntity testEntity){
        TestEntity t = testEntity;
        return t;
        //http://127.0.0.1:8080/mvc9?id=7
        //{"id":7,"name":null}
    }
    /**@RequestBody接收json，与对象属性进行对应*/
    @GetMapping(value = "/mvc10")
    @ResponseBody
    public TestEntity test10(@RequestBody TestEntity testEntity){
        TestEntity t = testEntity;
        return t;
    }
}
