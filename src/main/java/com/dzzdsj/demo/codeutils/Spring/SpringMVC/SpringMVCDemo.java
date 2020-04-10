package com.dzzdsj.demo.codeutils.Spring.SpringMVC;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

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
    /**MultipartFile 接收上传文件 对应multipart/form-data 形式*/
    @GetMapping(value = "/mvc11")
    @ResponseBody
    public String test11(MultipartFile file) throws Exception{
        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            byte[] byteArray = file.getBytes();
            InputStream ins = file.getInputStream();
            int b =0;
            while ((b = ins.read()) != -1) {
                System.out.print((char) b);
            }
            //something to do
            return "ok";
        }
        return "empty";
        /**
         * getOriginalFilename ， 获取上传的文件名字：
        getBytes ，我取上传文件内容，转为字节数组：
        getInputStream，获取一个InputStream;
        isEmpty ， 文件上传内容为空，或者就没有文件上传：
        getSize ， 文件上传的大小；
        transferToσile dest）， 保存上传文件到目标文件系统*/

/*        配置相关：
        spring:
        servlet:
#    文件上传相关配置
        multipart:
#      允许附件上传
        enabled: true
#      限定了当上传的文件超过一定长度时，就先写到临时文件里。这有助于上传文件不占用过多的内存，单位是MB 或者KB，默认是0,即不限定阔值。
        file-size-threshold: 0
#      临时文件的存放目录，如果不设定，则是Web 服务器提供的一个临时目录。
        location:
#        单个文件的最大长度，默认是1MB
        max-file-size: 3MB
#      单次HTTP 请求上传的最大长度，默认是10MB
        max-request-size: 10MB
#      当文件和参数被访问的时候再解析成文件
        resolve-lazily: false*/
    }
    /**MultipartFile[] 上传多个文件，使用数组接收*/
    @GetMapping(value = "/mvc12")
    @ResponseBody
    public String test12(MultipartFile[] files) throws Exception{
        for(MultipartFile file: files) {
            String fileName = file.getOriginalFilename();
            byte[] byteArray = file.getBytes();
            InputStream ins = file.getInputStream();
            int b = 0;
            while ((b = ins.read()) != -1) {
                System.out.print((char) b);
            }
            //something to do
        }
        return "ok";
    }
}
