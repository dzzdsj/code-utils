package com.dzzdsj.demo.codeutils.DesignPattern.FactoryPattern;

/**
 * 产品的子类
 */
public class IDcard extends Product {
    private String owner;

    public IDcard(String owner) {
        System.out.println("制作" + owner + "的ID卡");
        this.owner = owner;
    }

    @Override
    void use() {
        System.out.println("使用" + owner + "的ID卡");
    }

    String getOwner() {
        return owner;
    }
}
