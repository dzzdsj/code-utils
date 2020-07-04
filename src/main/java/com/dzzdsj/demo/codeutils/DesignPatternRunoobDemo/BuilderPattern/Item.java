package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.BuilderPattern;

//定义食物的接口
public interface Item {
    String name();

    Packing packing();

    double price();
}
