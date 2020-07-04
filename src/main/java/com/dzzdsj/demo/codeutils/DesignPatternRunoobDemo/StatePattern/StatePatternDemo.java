package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.StatePattern;

/**
 * 状态模式（State Pattern）中，类的行为是基于它的状态改变的。
 * 使用场景： 1、行为随状态改变而改变的场景。 2、条件、分支语句的代替者。
 * 好处: 通过将每个状态封装到类中，将以后需要做的任何改变局部化,将变化分开封装，以后
 * 要是某个状态中的操作改了，不需要查找整个IF了，找到对应类修改,或者以后添加某个状态的话，
 * 就不需要修改IF, 而是添加状态，修改部分状态中的代码
 * 缺点: 使用状态类通常会导致设计类的数量大量增加
 */

/**
 * 状态模式和策略模式的区别
 * 1、状态模式重点在各状态之间的切换从而做不同的事情，而策略模式更侧重于根据具体情况选择策略，并不涉及切换。
 *
 * 2、状态模式不同状态下做的事情不同，而策略模式做的都是同一件事，例如聚合支付平台，有支付宝、微信支付、银联支付，虽然策略不同，但最终做的事情都是支付，也就是说他们之间是可替换的。反观状态模式，各个状态的同一方法做的是不同的事，不能互相替换。
 *
 * 状态模式封装了对象的状态，而策略模式封装算法或策略。因为状态是跟对象密切相关的，它不能被重用；而通过从Context中分离出策略或算法，我们可以重用它们。
 *
 * 在状态模式中，每个状态通过持有Context的引用，来实现状态转移；但是每个策略都不持有Context的引用，它们只是被Context使用。
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
