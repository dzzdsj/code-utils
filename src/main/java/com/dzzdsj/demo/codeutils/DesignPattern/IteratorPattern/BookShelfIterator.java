package com.dzzdsj.demo.codeutils.DesignPattern.IteratorPattern;

/**
 * Iterator 接口的具体实现类
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        }
        return false;
    }

    /**
     * 这个方法和书橱的具体实现类挂钩，修改了具体实现类的相关方法，则这个方法也要修改
     *
     * @return
     */
    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
