package com.dzzdsj.demo.codeutils.DesignPattern.IteratorPattern;

/**
 *迭代器模式（Iterator Pattern）
 * 这种模式用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。
 * 提供一种方法顺序访问一个聚合对象中各个元素, 而又无须暴露该对象的内部表示
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
