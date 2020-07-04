package com.dzzdsj.demo.codeutils.DesignPattern.VisitorPattern.CompositePattern;

/**
 * 表示目录条目的抽象类:统一了 File 和 Directory 类
 * 父类声明实现Element 接口，实际由它的子类去具体实现
 */
public abstract class Entry implements Element {
    abstract String getName();

    abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    //打印目录条目一览
    void printList() {
        printList("");
    }

    //打印带前缀的
    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
