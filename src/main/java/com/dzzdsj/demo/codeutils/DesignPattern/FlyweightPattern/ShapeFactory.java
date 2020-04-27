package com.dzzdsj.demo.codeutils.DesignPattern.FlyweightPattern;

import java.util.HashMap;
//步骤 3
//创建一个工厂，生成基于给定信息的实体类的对象。
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();//利用hashmap存储对象，重复利用。
    // 这里颜色是公有的属性，可以重复使用，取出对象后重新设置位置信息即可

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);  //已有对象直接从hashmap取出

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);//验证对象被创建了几次,验证复用对象
        }
        return circle;
    }
}
