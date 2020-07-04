package com.dzzdsj.demo.codeutils.DesignPattern.PrototypePattern;

import java.util.HashMap;

/**
 * 管理和复制对象实例的类
 */
public class Manager {
    private HashMap showcase = new HashMap();

    public void register(String name, Product product) {
        showcase.put(name, product);
    }

    public Product create(String protoname) {
        Product p = (Product) showcase.get(protoname);
        return p.createClone();
    }
}
