package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

public abstract class ColdDrink implements Item {

    @Override
    public Packing  packing() {
        return new Bottle();
    }

    @Override
    public abstract double price();
}
