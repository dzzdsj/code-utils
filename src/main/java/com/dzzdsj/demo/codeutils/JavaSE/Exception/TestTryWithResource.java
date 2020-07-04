package com.dzzdsj.demo.codeutils.JavaSE.Exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 若待关闭的对象实现了AutoCloseable接口，可以使用try-with-resources 简化关闭语法
 * https://blog.csdn.net/weixin_40255793/article/details/80812961
 */
public class TestTryWithResource {
    public static void main(String[] args) {
        int b = 0;
        try (FileInputStream fis = new FileInputStream("D:\\git\\myGit\\demo\\code-utils\\src\\main\\java\\com\\dzzdsj\\demo\\codeutils\\JavaSE\\IO\\testIO.txt");
        ) {
            long num = 0;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
                num++;
            }
            System.out.println("----------");
            System.out.println(num);
        } catch (IOException e) {
            System.out.println("###########");
            System.out.println(e.getMessage());
            //try 块中抛出的异常，在 e.getMessage() 可以获得，而调用 close() 方法抛出的异常在e.getSuppressed() 获得。
            //try 块没有发生异常时，自动调用 close 方法，如果发生异常，catch 块捕捉并处理异常。
            //try 块发生异常，然后自动调用 close 方法，如果 close 也发生异常，catch 块只会捕捉 try 块抛出的异常，
            // close 方法的异常会在catch 中被压制，但是你可以在catch块中，用 Throwable.getSuppressed 方法来获取到压制异常的数组。
            System.out.println(e.getSuppressed());
            e.printStackTrace();
        }
    }
}
