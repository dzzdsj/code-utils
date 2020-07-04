package com.dzzdsj.demo.codeutils.JavaSE.Thread.sleepThread;//: concurrency/SleepingTask.java
// Calling sleep() to pause for a while.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask {
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i = 0; i < 5; i++)
      exec.execute(new WelcomeTask());
    exec.shutdown();
  }
}

class WelcomeTask implements Runnable {
  // 在该方法中实现线程的任务处理逻辑
  @Override
  public void run() {
    System.out.printf("2.Welcome! I'm %s.%n", Thread.currentThread().getName());
    try {
      // Old-style:
      // Thread.sleep(100);
      // Java SE5/6-style:
      /**
       * Java SE5/6-style:  sleep的另一种写法
       */
      TimeUnit.MILLISECONDS.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // 输出“当前线程”的线程名称
    System.out.printf("2.Welcome! I'm %s.%n", Thread.currentThread().getName());
  }

}
