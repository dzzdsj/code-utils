package com.dzzdsj.demo.codeutils.JavaSE.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator 基本用法
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("a");
        c.add("bb");
        c.add("ss");
        Iterator it = c.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //不会进入循环，游标没有重置方法。需要重新得到一个Iterator对象
        while (it.hasNext()){
            if(it.next().equals("ss")){
                it.remove();
            }
        }
        //另一种for的形式使用
        for(Iterator iterator = c.iterator();iterator.hasNext();){
            String s = (String) iterator.next();
            if(s.equals("ss")) {
                /**iterator的remove方法是迭代过程中删除元素的唯一安全方法，不能使用容器本身的remove方法（但多线程下仍有问题https://www.cnblogs.com/zhuyeshen/p/10956822.html）*/
                iterator.remove();
//                c.remove(s);//throw java.util.ConcurrentModificationException
            }
        }
        for(Iterator iterator2 = c.iterator();iterator2.hasNext();){
            System.out.println(iterator2.next());
        }
    }
}
