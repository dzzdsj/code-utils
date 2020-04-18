package com.dzzdsj.demo.codeutils.SpringBootDemo.Jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"id","phone"})  //忽略一组属性,作用于类上
public class JacksonUser {
    @JsonProperty("userName")//为JSONKey 指定一个别名
    @JsonIgnore //作用在属性上，用来忽略此属性
    private String name;

    private int id;
    private String phone;
}
