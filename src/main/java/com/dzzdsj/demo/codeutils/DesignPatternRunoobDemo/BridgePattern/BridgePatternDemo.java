package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.BridgePattern;

//桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化
//这种模式涉及到一个作为桥接的接口，使得实体类的功能独立于接口实现类
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
