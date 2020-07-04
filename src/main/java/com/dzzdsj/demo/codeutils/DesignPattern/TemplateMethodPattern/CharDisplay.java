package com.dzzdsj.demo.codeutils.DesignPattern.TemplateMethodPattern;

/**
 * 父类抽象类的具体实现
 */
public class CharDisplay extends AbstractDisplay {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    void open() {
        System.out.print("<");
    }

    @Override
    void close() {
        System.out.println(">");
    }

    @Override
    void print() {
        System.out.print(ch);
    }
}
