package com.dzzdsj.demo.codeutils.JavaSE.Array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 数组排序
 */
public class ArraySort {
    public static void main(String[] args) {
        double[] array = new double[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        long startTime = System.currentTimeMillis();
        Arrays.sort(array);
        System.out.println("cost:" + (System.currentTimeMillis() - startTime));
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
        List<Double> doubleList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            doubleList.add(Math.random());
        }
        long startTime2 = System.currentTimeMillis();
        Collections.sort(doubleList);
        System.out.println("cost:" + (System.currentTimeMillis() - startTime2));
    }
}
