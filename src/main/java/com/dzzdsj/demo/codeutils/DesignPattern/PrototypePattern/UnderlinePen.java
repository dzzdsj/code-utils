package com.dzzdsj.demo.codeutils.DesignPattern.PrototypePattern;

/**
 * 类的作用是装饰字符串
 */
public class UnderlinePen implements Product {
    private char decochar;

    //接收指定的装饰符
    public UnderlinePen(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.println(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product product = null;
        try {
            product = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
