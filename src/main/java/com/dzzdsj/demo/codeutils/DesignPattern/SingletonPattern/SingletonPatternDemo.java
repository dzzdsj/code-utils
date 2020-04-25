package com.dzzdsj.demo.codeutils.DesignPattern.SingletonPattern;

/**
 * 单例模式
 * 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一
 * 的对象的方式，可以直接访问，不需要实例化该类的对象
 */

/**
 * 使用场景：
 * 1、要求生产唯一序列号。
 * 2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。
 * 3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
 * 注意事项：getInstance() 方法中需要使用同步锁 synchronized (Singleton.class)
 * 防止多线程同时进入造成 instance 被多次实例化。
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();
        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();
        //显示消息
        object.showMessage();
    }
}
