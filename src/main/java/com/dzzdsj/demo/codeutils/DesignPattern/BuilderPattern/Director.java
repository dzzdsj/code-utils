package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

/**
 * 利用建造者类（实际传入它的子类）编写文档
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 构建文档的方法
     */
    public void constrcut() {
        builder.makeTitle("早上好");
        builder.makeString("从早上到下午");
        builder.makeItems(new String[]{
                "早上好",
                "下午好"
        });
        builder.close();
    }
}
