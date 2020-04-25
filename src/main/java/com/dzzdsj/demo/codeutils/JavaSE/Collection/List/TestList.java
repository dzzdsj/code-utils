package com.dzzdsj.demo.codeutils.JavaSE.Collection.List;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
//        System.out.println(list.get(-1));
        System.out.println(list.get(0));
//        System.out.println(list.get(1));
    }
}
