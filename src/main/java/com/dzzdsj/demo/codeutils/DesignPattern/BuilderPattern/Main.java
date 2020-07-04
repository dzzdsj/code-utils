package com.dzzdsj.demo.codeutils.DesignPattern.BuilderPattern;

/**
 * 建造者模式：组装具有复杂结构的实例
 */
public class Main {
    public static void main(String[] args) {
        TextBuilder textBuilder = new TextBuilder();
        Director director = new Director(textBuilder);
        director.constrcut();
        String result = textBuilder.getResult();
        System.out.println(result);
        //todo htmlbuilder
    }
}
