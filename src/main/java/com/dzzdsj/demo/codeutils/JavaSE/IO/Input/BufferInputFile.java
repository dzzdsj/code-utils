package com.dzzdsj.demo.codeutils.JavaSE.IO.Input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取并打印文本文件内容
 */
public class BufferInputFile {
    public static void main(String[] args) {
        System.out.print(readTextFromFile("D:/总结/centOS7配置操作总结.txt"));
    }
    public static String readTextFromFile(String filename) {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String s;
            StringBuffer sb = new StringBuffer();
            while ((s = in.readLine()) != null){
                sb.append(s + "\n");
            }
//            in.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
