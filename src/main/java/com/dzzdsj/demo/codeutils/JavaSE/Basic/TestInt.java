package com.dzzdsj.demo.codeutils.JavaSE.Basic;

public class TestInt {
    public static void main(String[] args) {
        int a = 8;
        int b = -8;
        int c = 7;
        int d = -7;
        System.out.println("二进制输出" + Integer.toBinaryString(a));
        System.out.println("八进制输出" + Integer.toOctalString(a));
        //按10位八进制输出，向右靠齐，左边用0补齐
        System.out.printf("八进制输出" + "%010o\n", a);
        System.out.println("十六进制输出" + Integer.toHexString(a));
        //按10位十六进制输出，向右靠齐，左边用0补齐
        System.out.printf("十六进制输出" + "%010x\n", a);
    }
}
