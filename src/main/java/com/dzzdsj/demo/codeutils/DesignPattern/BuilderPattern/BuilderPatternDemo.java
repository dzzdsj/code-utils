package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

/**
 * 建造者模式:使用多个简单的对象一步一步构建成一个复杂的对象
 * 何时使用：一些基本部件不会变，而其组合经常变化的时候
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " +vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }
}
