package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.BuilderPattern;

public class VegBurger extends Burger {
    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public double price() {
        return 20.02d;
    }
}
