package com.dzzdsj.demo.codeutils.DesignPattern.AdapterPattern;

/**
 * 适配器类：包装原有的接口，提供新的接口，在中间做一个转换的作用
 * 形式一：委托的形式:自身不直接对接口转换进行处理，把它交给Banner的实例
 */
public class PrintBanner2 implements Print {
    //将Banner作为它的成员变量
    private Banner banner;

    public PrintBanner2(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
