package com.dzzdsj.demo.codeutils.DesignPattern.DecoratorPattern;

/**
 * 打印字符串的抽象类： 原始的类
 */
public abstract class Display {
    //获取横向字符数
    abstract int getColumns();

    //获取行数
    abstract int getRows();

    //获取第row行字符串
    abstract String getRowText(int row);

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
