package com.dzzdsj.demo.codeutils.JavaSE.Array;

import java.util.Date;

/**
 * 数组变量属引用类型，数组也可看作是对象，数组中的每个元素看成是它的成员变量
 * 声明数组时不能指定其长度int a[5]; 是错误的
 */
public class ArrayDemo {
    public static void main(String[] args) {
        /**动态初始化*/
        int[] array;
        array = new int[5];
        for(int i=0;i<array.length;i++){
            /**按成员变量的规则默认初始化*/
            System.out.println(array[i]);//默认初始化的值是0
            array[i]=i;
        }
        String[] strArr;
        strArr = new String[5];
        for(int i=0;i<strArr.length;i++){
            System.out.println(strArr[i]);//默认初始化的值是null
            strArr[i]=i+"";
        }
//        int[] b = new int[5];
        /**静态初始化*/
        int[] intArr = {1,2,3};
        Date[] days = {
                new Date(),
                new Date()
        };

        /**多维数组(看成数组的数组)的初始化要从高维到低维的顺序进行*/
        /**动态初始化*/
        int a[][] = new int[3][];
        a[0] = new int[2];
        a[1] = new int[3];
        a[2] = new int[4];
        int c[][] = new int[3][6];//同时分配的写法
        /**静态初始化*/
        int b[][] = {{1,2},{1,3,4},{2,3,4,5}};
        /**遍历二维数组*/
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[i].length;j++){
                System.out.println("b["+i+"]["+j+"]="+b[i][j]+"");
            }
        }
        /**数组的拷贝*/
        int[] d = {1,2,3};
        int[] e = {2,3,4,5};
        System.arraycopy(d,0,e,0,d.length);
        e[0] = 100;
        System.out.println("-------e");
        for(int i=0;i<e.length;i++) {
            System.out.println(e[i]);
        }
        System.out.printf("--------d");
        for(int i=0;i<d.length;i++) {
            System.out.println(d[i]);
        }
    }
}
