package com.dzzdsj.demo.codeutils.JavaSE.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestOutputStream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int b = 0;
        try {
            fis = new FileInputStream("D:\\git\\myGit\\demo\\code-utils\\src\\main\\java\\com\\dzzdsj\\demo\\codeutils\\JavaSE\\IO\\testIO.txt");
            fos = new FileOutputStream("D:\\git\\myGit\\demo\\code-utils\\src\\main\\java\\com\\dzzdsj\\demo\\codeutils\\JavaSE\\IO\\testOut.txt");
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
            fis.close();
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
