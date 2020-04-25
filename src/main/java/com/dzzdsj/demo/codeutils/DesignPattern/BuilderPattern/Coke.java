package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

public class Coke extends ColdDrink {

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public double price() {
        return 1.2d;
    }
}
