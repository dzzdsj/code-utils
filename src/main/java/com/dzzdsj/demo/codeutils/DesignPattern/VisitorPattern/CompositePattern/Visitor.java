package com.dzzdsj.demo.codeutils.DesignPattern.VisitorPattern.CompositePattern;

/**
 * 访问者类:重载的方法用于接收访问者的实例，通过接收到的访问实例，自动识别到底是哪个类的实例正在访问
 */
public abstract class Visitor {
    abstract void visit(File file);

    abstract void visit(Directory directory);
}
