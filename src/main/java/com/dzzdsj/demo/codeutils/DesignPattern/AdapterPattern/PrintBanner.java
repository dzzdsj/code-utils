package com.dzzdsj.demo.codeutils.DesignPattern.AdapterPattern;

/**
 * 适配器类：包装原有的接口，提供新的接口，在中间做一个转换的作用
 * 形式一：继承的形式
 */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
