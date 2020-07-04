package com.dzzdsj.demo.codeutils.JavaSE.IO.FileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    /**
     * 多个文件
     * @param filename
     * @param splitter
     */
    public TextFile(String filename, String splitter){
        super(Arrays.asList(filename.split(splitter)));
        //正则匹配的时候经常会在开头留下空串
        if(get(0).equals("")){
            remove(0);
        }
    }

    /**
     * 单个
     * @param filename
     */
    public TextFile(String filename){
        this(filename, "\n");
    }

    /**
     * 从文本文件按行读取文本
     * @param filename
     * @return
     */
    public static String read(String filename){
        StringBuffer sb = new StringBuffer();

        try (BufferedReader in = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()))) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 文本写入文件
     * @param filename
     * @param text
     */
    public static void write(String filename, String text){
        try (PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile())) {
            out.print(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(String filename){
        try (PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile())) {
            for (String item : this) {
                out.println(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = read("D:/git/myGit/demo/code-utils/src/main/java/com/dzzdsj/demo/codeutils/JavaSE/IO/testIO.txt");
        write("D:/git/myGit/demo/code-utils/src/main/java/com/dzzdsj/demo/codeutils/JavaSE/IO/copy.txt", file);
        TextFile text = new TextFile("D:/git/myGit/demo/code-utils/src/main/java/com/dzzdsj/demo/codeutils/JavaSE/IO/testIO.txt");
        text.write("D:/git/myGit/demo/code-utils/src/main/java/com/dzzdsj/demo/codeutils/JavaSE/IO/copy2.txt");
        TreeSet<String> words = new TreeSet<>(new TextFile("D:/git/myGit/demo/code-utils/src/main/java/com/dzzdsj/demo/codeutils/JavaSE/IO/testIO.txt","\\W+"));
        System.out.println(words.headSet("a"));
    }
}
