package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

//套餐类。用于组合基础的食物形成套餐
public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public double getCost(){
        double cost = 0.0d;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
