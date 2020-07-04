package com.dzzdsj.demo.codeutils.Spring.SpringMVC;

import lombok.Data;

@Data
public class TestEntity {
    private int id;
    private String name;

    TestEntity() {
    }

    TestEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
