package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

public class Pepsi extends ColdDrink {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public double price() {
        return 2.2d;
    }
}
