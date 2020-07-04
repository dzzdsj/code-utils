package com.dzzdsj.demo.codeutils.DesignPattern.FactoryPattern;

/**
 * 工厂模式：可以理解为当模板模式的子类执行的任务是生成实例时。算是一种特例
 * 不用new 来生成实例，而用create ，可以防止父类和其他具体类耦合。
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product product1 = factory.create("tom");
        Product product2 = factory.create("jerry");
        Product product3 = factory.create("mimi");
        product1.use();
        product2.use();
        product3.use();

    }
}
