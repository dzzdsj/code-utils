package com.dzzdsj.demo.codeutils.DesignPattern.FactoryPattern;


/**
 * 工厂模式：创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。
 * 工厂模式是为了解耦：可以将对象的创建和使用分离，如果不分离，不但违反了设计模式的开闭原则，
 * 需要使用另一个子类的话，需要修改源代码 ,把对象的创建和使用的过程分开。
 * 工厂模式可以降低代码重复（重复的初始化，对初始化过程很复杂的情况）
 */

/**
 *步骤 4
 * 使用该工厂，通过传递类型信息来获取实体类的对象。
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();
        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");
        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
