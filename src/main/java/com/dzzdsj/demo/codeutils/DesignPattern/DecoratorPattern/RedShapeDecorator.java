package com.dzzdsj.demo.codeutils.DesignPattern.DecoratorPattern;

//步骤 4
//创建扩展了 ShapeDecorator 类的实体装饰类。
public class RedShapeDecorator extends ShapeDecorator {
    //扩展
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
