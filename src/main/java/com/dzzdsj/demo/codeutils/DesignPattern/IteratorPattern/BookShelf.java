package com.dzzdsj.demo.codeutils.DesignPattern.IteratorPattern;

/**
 * 书橱 集合的具体实现类
 */
public class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;

    /**
     * 构造指定大小的书橱
     *
     * @param maxSize
     */
    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    /**
     * 获取指定位置的图书
     *
     * @param index
     * @return
     */
    public Book getBookAt(int index) {
        return books[index];
    }

    /**
     * 往书橱的末尾放书
     *
     * @param book
     */
    public void appendBook(Book book) {
        books[last] = book;
        last++;
    }

    /**
     * 获取书本的数目
     *
     * @return
     */
    public int getLength() {
        return last;
    }

    /**
     * 定义返回值为一个接口，return他的具体实现类
     *
     * @return
     */
    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
