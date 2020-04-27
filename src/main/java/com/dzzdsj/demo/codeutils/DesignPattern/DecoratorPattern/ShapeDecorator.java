package com.dzzdsj.demo.codeutils.DesignPattern.DecoratorPattern;

//步骤 3
//创建实现了 Shape 接口的抽象装饰类。
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;//不使用继承，而将它做为一个属性

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
