package com.dzzdsj.demo.codeutils.DesignPattern.Singleton;

public class Singlenton {
    /**
     * 类初始化即加载，static 确保只有一个实例
     */
    private static Singlenton singlenton = new Singlenton();

    /**
     * 指定 private 的构造函数，防止其他类用 new 来调用
     */
    private Singlenton() {
        System.out.println("生成了一个实例");
    }

    public static Singlenton getInstance() {
        return singlenton;
    }
}
