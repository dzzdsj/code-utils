package com.dzzdsj.demo.codeutils.DesignPattern.BridgePattern;

/**
 * 属于功能层次结构：新增功能的做法是新建一个子类，在子类中增加方法
 * 该类在顶层功能层次结构的基础上新增了multiDisplay方法
 */
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl displayImpl) {
        super(displayImpl);
    }

    /**
     * 新增的功能方法
     */
    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
