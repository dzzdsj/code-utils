package com.dzzdsj.demo.codeutils.JavaSE.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestInputStream {
    public static void main(String[] args) {
        int b = 0;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\git\\myGit\\demo\\code-utils\\src\\main\\java\\com\\dzzdsj\\demo\\codeutils\\JavaSE\\IO\\testIO.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            try {
                long num = 0;
                while ((b = fis.read()) != -1) {
                    System.out.print((char) b);
                    num++;
                }
                fis.close();
                System.out.println("----------");
                System.out.println(num);
            } catch (IOException e1) {
                e.printStackTrace();
            }
        }
    }
}