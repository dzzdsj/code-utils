package com.dzzdsj.demo.codeutils.JavaSE.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁Demo
 * 使用场景：同时满足以下条件
 * 1.读操作比写操作要频繁的多
 * 2.读线程持有锁的时间比较长
 */
public class ReadWriteLockDemo {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public void reader(){
        readLock.lock();
        try{
            //读共享变量
        }finally {
            readLock.unlock();//在finally里释放锁，避免锁泄漏
        }
    }

    public void writer(){
        writeLock.lock();
        try{
            //读、写共享变量
        }finally {
            writeLock.unlock();//在finally里释放锁，避免锁泄漏
        }
    }

    //ReentrantReadWriteLock支持锁的降级：即持有写锁的情况下继续申请读锁
    // 而不支持锁的升级，升级需要先释放读锁，再申请写锁
    public void operationWithLockDowngrade(){
        boolean readLockAcquired = false;
        writeLock.lock(); // 申请写锁
        try {
            // 对共享数据进行更新
            // ...
            // 当前线程在持有写锁的情况下申请读锁readLock
            readLock.lock();
            readLockAcquired = true;
        } finally {
            writeLock.unlock();// 释放写锁
        }

        if (readLockAcquired) {
            try {
                // 读取共享数据并据此执行其他操作
                // ...

            } finally {
                readLock.unlock();// 释放读锁
            }
        } else {
            // ...
        }
    }
}
