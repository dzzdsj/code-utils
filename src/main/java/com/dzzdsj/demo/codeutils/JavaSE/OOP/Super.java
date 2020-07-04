package com.dzzdsj.demo.codeutils.JavaSE.OOP;

import java.util.Random;

public class Super {
    //即使子类也不能访问
    private int num;
    protected int phone;
    private static String addr;
    //不同包的子类
    protected static String addr1;
    //defaut  同一个包
    static String addr2;
    private void getNum() {
        int x;
    }

    public static void main(String[] args) {
        /**
         * 如果设置了随机数种子，总是会产生相同的序列
         */
        Random random = new Random(3);
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());
        Random rd = new Random();
        System.out.println("rd=="+rd.nextInt());
        System.out.println("rd=="+rd.nextInt());
        System.out.println("rd=="+rd.nextInt());
        System.out.println("rd=="+rd.nextInt());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
    }
}
class Another {
    void getVar(){
        //能访问 pro
        Super.addr1 = "3";
    }
}