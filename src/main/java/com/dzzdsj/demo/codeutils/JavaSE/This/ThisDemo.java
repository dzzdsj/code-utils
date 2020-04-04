package com.dzzdsj.demo.codeutils.JavaSE.This;

import org.apache.poi.ss.formula.functions.T;

/**
 * 调用方法的对象是谁，this就是谁的引用。
 * 还经常用来处理成员变量和局部变量同名的情况
 */
public class ThisDemo {
    int i = 0;

    public ThisDemo(int i) {
        this.i = i;
    }
    ThisDemo increament(){
        i++;
        return this;
    }
    void print(){
        System.out.println("i="+i);
    }

    public static void main(String[] args) {
        ThisDemo thisDemo = new ThisDemo(100);
        thisDemo.increament().increament().print();//102
    }
}
