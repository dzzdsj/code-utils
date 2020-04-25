package com.dzzdsj.demo.codeutils;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
//        for (int i = 0; i <20 ; i++) {
//            double random = Math.random();
//            System.out.println(random);
//            System.out.println((int)(random*5));
//        }
        Date date = new Date();
        long dateTime = date.getTime();
        System.out.println(dateTime);
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
    }
}
