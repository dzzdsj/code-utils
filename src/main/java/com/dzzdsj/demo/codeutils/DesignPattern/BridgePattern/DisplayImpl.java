package com.dzzdsj.demo.codeutils.DesignPattern.BridgePattern;

/**
 * 类的实现层次结构的最上层
 */
public abstract class DisplayImpl {
    /**
     * 实现层次结构中方法的最原始的定义
     */
    abstract void rawOpen();

    abstract void rawPrint();

    abstract void rawClose();
}
