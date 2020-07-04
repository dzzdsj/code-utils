package com.dzzdsj.demo.codeutils.DesignPattern.BridgePattern;

/**
 * 桥接模式：连接 类的功能层次结构  和  类的实现层次结构
 * 类的功能层次结构： 类需要增加新的方法时，在类的层级中的合适的层级新建它的子类，然后在子类中新增新的方法
 * 类的实现层次结构： 父类定义抽象方法，由子类来实现，需要新的实现时，新建子类进行具体的实现
 */
public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("hello"));
        //只有顶级功能结构的功能
        Display d2 = new CountDisplay(new StringDisplayImpl("hello"));
        //包含新增的功能
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("hello"));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(3);
    }
}
