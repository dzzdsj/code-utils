package com.dzzdsj.demo.codeutils.DesignPattern.StatePattern;

/**
 *状态模式（State Pattern）中，类的行为是基于它的状态改变的。
 * 使用场景： 1、行为随状态改变而改变的场景。 2、条件、分支语句的代替者。
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
