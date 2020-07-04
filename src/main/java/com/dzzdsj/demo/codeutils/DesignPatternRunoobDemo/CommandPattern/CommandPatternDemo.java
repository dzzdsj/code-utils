package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.CommandPattern;

/**
 * 命令模式（Command Pattern）是一种数据驱动的设计模式
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
