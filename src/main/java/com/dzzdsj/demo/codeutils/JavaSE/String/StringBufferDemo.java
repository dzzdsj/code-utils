package com.dzzdsj.demo.codeutils.JavaSE.String;

/**
 * 可变字符序列
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("dd");
        sb.append("ee");//
        System.out.println(sb);
        sb.insert(1,"kk");
        System.out.println(sb);
        sb.delete(2,2);
        System.out.println(sb);
        System.out.println(sb.reverse());//
        System.out.println(sb.indexOf("k"));
    }
}
