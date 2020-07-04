package com.dzzdsj.demo.codeutils.JavaSE.Array;

public class Exercise {
    public static void main(String[] args) {
        int[][] array = {{1, 2}, {3, 4}, {5, 6}};
        int[][] arrayBak = new int[3][];  //与下面比较写法
        System.arraycopy(array, 0, arrayBak, 0, array.length);
        arrayBak[2][1] = 100;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);          //原数组的值被改变了
            }
        }
        System.out.println("-----------------1");
        int[][] array2 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] array2Bak = new int[3][2];  //与上面比较写法
        for (int i = 0; i < array2.length; i++) {
            System.arraycopy(array2[i], 0, array2Bak[i], 0, array[i].length);//copy的方式改变
        }
        arrayBak[2][1] = 100;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array2[i][j]);   //原数组的值没有变化
            }
        }
        System.out.println("-----------------2");
        int[] arr = {1, 2, 3};
        int[] arrBak = new int[3];
        System.arraycopy(arr, 0, arrBak, 0, array.length);
        arrBak[2] = 100;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);    //原数组的值没有变化
        }
    }
}
