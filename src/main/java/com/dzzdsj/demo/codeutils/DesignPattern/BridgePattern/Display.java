package com.dzzdsj.demo.codeutils.DesignPattern.BridgePattern;

/**
 * 类的功能层次结构的最上层，同时也时连接类的实现层次结构的桥梁
 */
public class Display {
    /**
     * 用聚合关系连接 类的实现层次的具体实现类
     */
    private DisplayImpl displayImpl;

    public Display(DisplayImpl displayImpl) {
        this.displayImpl = displayImpl;
    }

    /**
     * 在方法中调用 实现层次结构类的代码
     */
    public void open() {
        displayImpl.rawOpen();
    }

    public void print() {
        displayImpl.rawPrint();
    }

    public void close() {
        displayImpl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
