package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.AbstractFactoryPattern;

/**
 * 步骤 2
 * 创建实现接口的实体类。
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("I'm Circle");
    }
}
