package com.dzzdsj.demo.codeutils.DesignPattern.AbstractFactoryPattern;

/**
 * 抽象工厂模式,其他工厂的工厂,负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取形状为 Circle 的对象
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();
        //获取形状为 Square 的对象
        Shape shape3 = shapeFactory.getShape("SQUARE");
        //调用 Square 的 draw 方法
        shape3.draw();
        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        //获取颜色为 Green 的对象
        Color color2 = colorFactory.getColor("Green");
        //调用 Green 的 fill 方法
        color2.fill();
        //获取颜色为 Blue 的对象
        Color color3 = colorFactory.getColor("BLUE");
        //调用 Blue 的 fill 方法
        color3.fill();
    }
}
