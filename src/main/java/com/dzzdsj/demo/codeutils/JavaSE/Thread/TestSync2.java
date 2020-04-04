package com.dzzdsj.demo.codeutils.JavaSE.Thread;

/**
 * 同步方法的特点示例
 */
public class TestSync2 implements Runnable{
    int b = 100;
    //m1、m2同时加锁，这样保证了同时仅有一个方法在执行
    private synchronized void m1(){
        b = 1000;
        try {
            Thread.sleep(5000);
            System.out.println("m1--b:"+b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void m2(){
        try {
            Thread.sleep(2500);
            b = 2000;
            System.out.println("m2--b:"+b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        m1();
    }

    public static void main(String[] args) throws Exception{
        long t1 = System.currentTimeMillis();
        TestSync2 ts = new TestSync2();
        Thread t = new Thread(ts);
        t.start();
        ts.m2();
        Thread.sleep(6000);
        System.out.println("main--b:"+ts.b);
        System.out.println(System.currentTimeMillis()-t1);
    }
}
