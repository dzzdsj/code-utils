package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

public abstract class Burger implements Item {

    @Override
    public String pack() {
        return "Wrapper";
    }

    @Override
    public abstract double price();
}
