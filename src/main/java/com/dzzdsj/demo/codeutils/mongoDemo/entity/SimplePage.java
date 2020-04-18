package com.dzzdsj.demo.codeutils.mongoDemo.entity;

import lombok.Data;

import java.util.List;

@Data
public class SimplePage {
    private Long totolNum;
    private Long totolPage;
    private Long currentPage;
    private List<?> dataList;
}
