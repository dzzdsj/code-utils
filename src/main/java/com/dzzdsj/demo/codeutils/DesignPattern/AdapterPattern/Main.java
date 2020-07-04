package com.dzzdsj.demo.codeutils.DesignPattern.AdapterPattern;

/**
 * 适配器模式：对原有的接口进行包装，提供新的接口进行适配。对原有类的修改不需要改变调用者
 * 主要作用：不修改现有的类，生成新的类。复用了现有的测试完全的类。如果对旧的类进行修改，则需要再进行测试，使用
 * 适配器的话出bug了直接排查适配器类即可。同时也不需要完全了解旧的代码，只需要知道它的功能即可使用
 * 处理新旧版本的兼容问题：只维护新版本，创造一个适配器兼容旧版本
 * 有继承和委托两种形式来处理
 */
public class Main {
    public static void main(String[] args) {
        Print print = new PrintBanner("hello");
        print.printStrong();
        print.printWeak();
        Print print2 = new PrintBanner2("world");
        print2.printWeak();
        print2.printStrong();
    }
}
