package com.dzzdsj.demo.codeutils.DesignPattern.PrototypePattern;

/**
 * 原型模式：当创建一个实例的代价很大的时候。当希望生成实例和原有的框架松耦合的时候。
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('+');
        manager.register("upen", upen);
        manager.register("mbox", mbox);
        manager.register("sbox", sbox);
        Product p1 = manager.create("upen");
        Product p2 = manager.create("mbox");
        Product p3 = manager.create("sbox");
        p1.use("hello");
        p2.use("hello");
        p3.use("hello");
    }
}
