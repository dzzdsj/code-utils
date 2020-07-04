package com.dzzdsj.demo.codeutils.JavaSE.Thread.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 利用Executors创建并管理线程
 */
public class WelcomeApp3 {
    public static void main(String[] args) {
        //创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们
//        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建指定个数的有限的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //单个线程，任务会排队，且不会并发调用(一个接一个)
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new WelcomeTask());
        }
        executorService.shutdown();
    }
}
