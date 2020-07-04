package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.BuilderPattern;

//套餐工厂类
public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new MealBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
