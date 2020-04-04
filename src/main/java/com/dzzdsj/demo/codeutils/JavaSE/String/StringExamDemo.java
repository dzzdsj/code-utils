package com.dzzdsj.demo.codeutils.JavaSE.String;

import java.sql.SQLOutput;

/**
 * String类易混淆点辨析
 */
public class StringExamDemo {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1==s2);//true,属于字符串常量，dataSegment
        System.out.println(s1.equals(s2));
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s3==s4);//false,对象，堆
        System.out.println(s3.equals(s4));//true,默认重写过了

    }

}
