package com.dzzdsj.demo.codeutils.DesignPattern.VisitorPattern.CompositePattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 文件夹类
 */
public class Directory extends Entry {
    private String name;
    //文件夹中的条目
    private List diredtory = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        int size = 0;
        Iterator iterator = diredtory.iterator();
        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        diredtory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator iterator = diredtory.iterator();
        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            entry.printList(prefix + "/" + name);
        }
    }

    /**
     * 传this，告诉visitor类当前的访问者时Directory的实例
     *
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
