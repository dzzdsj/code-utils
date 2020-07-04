package com.dzzdsj.demo.codeutils.JavaSE.String;

/**
 * 可变字符序列
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("dd");
        sb.append("ee");//ddee
        System.out.println(sb);
        sb.insert(1, "kk");//dkkdee
        System.out.println(sb);
        sb.delete(3, 4);//dkkee
        System.out.println(sb);
        System.out.println(sb.reverse());//eekkd
        System.out.println(sb.indexOf("k"));//2
    }
}
