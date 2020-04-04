package com.dzzdsj.demo.codeutils.JavaSE.Thread;

/**
 * 同步方法的特点示例
 */
public class TestSync implements Runnable{
    int b = 100;
    //虽然加了锁，但不能阻止未加锁的m2方法改变b的值。只能保证m1方法本身是原子性的。
    private synchronized void m1(){
        b = 1000;
        try {
            Thread.sleep(5000);
            System.out.println(b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //m1方法被锁定时，仍然可以执行更改b的值
    private void m2(){
        try {
            Thread.sleep(2500);
            b = 2000;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        m1();
    }

    public static void main(String[] args) {
        TestSync ts = new TestSync();
        Thread t = new Thread(ts);
        t.start();
        ts.m2();
        System.out.println(ts.b);
    }
}
