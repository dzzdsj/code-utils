package com.dzzdsj.demo.codeutils.DesignPattern.IteratorPattern;

/**
 * 迭代器接口
 */
public interface Iterator {
    /**
     * 是否有下一个元素（是否还可以调用next()方法）
     *
     * @return
     */
    boolean hasNext();

    /**
     * 返回下一个元素并将游标移动至下一个元素
     *
     * @return
     */
    Object next();
}
