package com.dzzdsj.demo.codeutils.DesignPattern.VisitorPattern.CompositePattern;

/**
 * 文件类
 */
public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        //字符串+this 自动调用tostring方法
        System.out.println(prefix + "/" + this);
    }

    /**
     * 传this，告诉visitor类当前的访问者时File的实例
     *
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
