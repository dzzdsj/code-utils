package com.dzzdsj.demo.codeutils.DesignPattern.CompositePattern;

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
}
