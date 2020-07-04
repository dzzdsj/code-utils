/*
授权声明：
本源码系《Java多线程编程实战指南（核心篇）》一书（ISBN：978-7-121-31065-2，以下称之为“原书”）的配套源码，
欲了解本代码的更多细节，请参考原书。
本代码仅为原书的配套说明之用，并不附带任何承诺（如质量保证和收益）。
以任何形式将本代码之部分或者全部用于营利性用途需经版权人书面同意。
将本代码之部分或者全部用于非营利性用途需要在代码中保留本声明。
任何对本代码的修改需在代码中以注释的形式注明修改人、修改时间以及修改内容。
本代码可以从以下网址下载：
https://github.com/Viscent/javamtia
http://www.broadview.com.cn/31065
*/
package com.dzzdsj.demo.codeutils.JavaSE.Thread.createThread;

/**
 * 继承Thread类方式，基于继承
 * 返回：
 * 1.Welcome! I'm main.
 * 2.Welcome! I'm Thread-1.
 * 2.Welcome! I'm Thread-0.
 */
public class WelcomeApp {

    public static void main(String[] args) {
        // 创建线程
        Thread welcomeThread = new WelcomeThread();
        Thread welcomeThread1 = new WelcomeThread();

        // 启动线程
        welcomeThread.start();
        welcomeThread.run();//这个run方法其实可以实际调用，但是并不会另起一个线程。必须使用start方法调用run才会另起一个线程。
        welcomeThread1.start();

        // 输出“当前线程”的线程名称
        System.out.printf("1.Welcome! I'm %s.%n", Thread.currentThread().getName());
    }
}

// 定义Thread类的子类
class WelcomeThread extends Thread {

    // 在该方法中实现线程的任务处理逻辑
    @Override
    public void run() {
        System.out.printf("2.Welcome! I'm %s.%n", Thread.currentThread().getName());
    }
}
