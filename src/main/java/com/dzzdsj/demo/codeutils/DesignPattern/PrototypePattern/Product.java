package com.dzzdsj.demo.codeutils.DesignPattern.PrototypePattern;

public interface Product extends Cloneable {
    void use(String s);

    Product createClone();
}
