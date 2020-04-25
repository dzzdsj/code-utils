package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

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
