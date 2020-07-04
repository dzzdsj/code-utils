package com.dzzdsj.demo.codeutils.DesignPattern.IteratorPattern;

/**
 * 使用iterator模式的作用是：将遍历和实现分开来。 针对同一个集合，可以定义多个iterator的实现类
 * 就算更改了集合的具体实现，这里的调用代码也不需要作修改
 */
public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("hello1"));
        bookShelf.appendBook(new Book("hello2"));
        bookShelf.appendBook(new Book("hello3"));
        bookShelf.appendBook(new Book("hello4"));
        //这里使用接口，就算iterator的具体实现类修改了，这里的代码也不需要修改
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book);
        }
    }
}
