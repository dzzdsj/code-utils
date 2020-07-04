package com.dzzdsj.demo.codeutils.DesignPattern.Singleton;

/**
 * 单例模式：
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("start");
        Singlenton singlenton1 = Singlenton.getInstance();
        Singlenton singlenton2 = Singlenton.getInstance();
        //true 说明是同一个实例对象
        if (singlenton1 == singlenton2) {
            System.out.println("true");
        }
    }
}
