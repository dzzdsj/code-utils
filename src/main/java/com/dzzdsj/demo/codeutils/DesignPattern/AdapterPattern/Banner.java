package com.dzzdsj.demo.codeutils.DesignPattern.AdapterPattern;

/**
 * 扮演原有实际的存在类，只有showWithParen和showWithAster 这两个方法
 */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
