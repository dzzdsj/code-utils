package com.dzzdsj.demo.codeutils.JavaSE.Thread;

/**
 * 线程间协作，模拟生产者消费者
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);
        new Thread(p).start();
        new Thread(p).start();
//        new Thread(c).start();
        new Thread(c).start();

    }
}
//窝头
class Wotou{
    //编号
    private int id;
    public Wotou(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Wotou{" +
                "id=" + id +
                '}';
    }
}
//装窝头的容器（栈）
class SyncStack{
    private int index =0;
    Wotou[] arrWT = new Wotou[6];
    //往容器装
    public synchronized void push(Wotou wt){
//        if(index == arrWT.length){
        while (index == arrWT.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        this.notify();
        this.notifyAll();
        arrWT[index] = wt;
        index ++;
    }
    //取出
    public synchronized Wotou pop(){
//        if(index == 0){
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        this.notify();
        this.notifyAll();
        index --;
        return arrWT[index];
    }
}

class Producer implements Runnable{
    SyncStack ss = null;

    public Producer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Wotou wt = new Wotou(i);
            ss.push(wt);
            System.out.println("producer"+wt);
            // TODO: 2020/3/25 不加睡眠时间可能有问题
            try {
                Thread.sleep((int)(1000*Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    SyncStack ss = null;

    public Consumer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Wotou wt = ss.pop();
            System.out.println("consumer"+wt);
            // TODO: 2020/3/25 不加睡眠时间可能有问题
            try {
                Thread.sleep((int)(1000*Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}