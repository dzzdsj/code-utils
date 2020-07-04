package com.dzzdsj.demo.codeutils.JavaSE.Enum;

public class EnumDemo {
    private enum MyEnum {red, green, yellow}

    ;//定义

    public static void main(String[] args) {
        MyEnum myEnum = MyEnum.green;//使用
        switch (myEnum) {
            case red:
                System.out.println("red");
                break;
            case green:
                System.out.println("green");
                break;
            case yellow:
                System.out.println("yellow");
                break;
            default:
                System.out.println("default");
        }
    }
}
