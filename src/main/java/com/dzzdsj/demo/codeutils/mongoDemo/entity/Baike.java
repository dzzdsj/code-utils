package com.dzzdsj.demo.codeutils.mongoDemo.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Baike {
    private String id;
    private String desc;
    private List<String> tag ;
    private Comment comment;
    private Date createDate;
    private Date updateDate;
}
