package com.dzzdsj.demo.codeutils.DesignPattern.TemplateMethodPattern;

/**
 * 抽象父类，只实现执行逻辑部分，其余的交给子类来实现
 */
public abstract class AbstractDisplay {
    abstract void open();

    abstract void close();

    abstract void print();

    /**
     * 实现逻辑：定义执行逻辑并声明为final，阻止子类重写
     */
    final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
