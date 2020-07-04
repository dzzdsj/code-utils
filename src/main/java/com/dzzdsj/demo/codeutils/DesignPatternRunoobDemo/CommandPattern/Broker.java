package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.CommandPattern;

import java.util.ArrayList;
import java.util.List;

//步骤 4
//创建命令调用类。
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
