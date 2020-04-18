package com.dzzdsj.demo.codeutils.RedisDemo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RedisTestUser implements Serializable {
    private static final long serialVersionUID = -3150643062592072560L;
    private Long id;
    private String name;
}
