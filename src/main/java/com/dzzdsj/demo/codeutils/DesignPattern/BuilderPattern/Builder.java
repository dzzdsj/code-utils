package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

public abstract class Builder {
    abstract void makeTitle(String title);

    abstract void makeString(String string);

    abstract void makeItems(String[] items);

    abstract void close();
}
