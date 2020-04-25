package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

public abstract class ColdDrink implements Item {

    @Override
    public String pack() {
        return "Bottle";
    }

    @Override
    public abstract double price();
}
