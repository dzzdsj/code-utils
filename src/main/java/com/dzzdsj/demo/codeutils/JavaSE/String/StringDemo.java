package com.dzzdsj.demo.codeutils.JavaSE.String;

import java.sql.SQLOutput;

/**
 * 不可变的字符序列
 */
public class StringDemo {
    public static void main(String[] args) {
        /**String类常用方法*/
        String str = "ab888aa";
        System.out.println(str.indexOf("888a"));//2  匹配的字符串第一个字符的索引
        System.out.println("kkkdddkk".substring(2));//kdddkk  从起始索引（包括）开始至结束
        System.out.println("kkkdddkk".substring(0,2));//kk   从起始索引开始（包括）至结束索引（不包括）
        System.out.println(str.matches("......."));
        System.out.println(str.replaceAll("\\d","-"));//正则替换
        System.out.println(str.replace("8","-"));//正常的字符串替换
        System.out.println(str.charAt(1));//b,返回第n个字符
        System.out.println(str.length());//7
        System.out.println(str.indexOf("8a"));//4，返回第一个出现的index,没有返回-1
        System.out.println(str.lastIndexOf("88"));//3，返回最后一个出现的index
        System.out.println(str.equals("Ab888aa"));//
        System.out.println(str.equalsIgnoreCase("AB888aA"));//比较,忽略大小写
        System.out.println("kkbbbs".startsWith("kk"));
        System.out.println("kkbbbs".endsWith("bs"));
        System.out.println("  AB888aA  ".trim());//
        System.out.println(String.valueOf(9L));//如果参数是对象看是否重写了toString方法
        //
        String[] strArray = "kk/kddd/ggh/ss/".split("/");

        String group = "fdfsF/ilePath".substring(0, "fdfsF/ilePath".indexOf("/"));//截取第一个“/”之前的字符串
        System.out.println(group);
        String path = "fdfsF/ilePath".substring("fdfsF/ilePath".indexOf("/")+1);//截取第一个“/”之后的字符串
        System.out.println(path);

        /**常用构造方法*/
//        String s1 = new String("dd");
//        char[] charArray = {'a','b','c','d'};
//        String s2 = new String(charArray);
//        String s3 = new String(charArray,1,2);
//        System.out.println(s1+"\n"+s2+"\n"+s3);

    }
}
