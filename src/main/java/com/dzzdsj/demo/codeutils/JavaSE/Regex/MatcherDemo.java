package com.dzzdsj.demo.codeutils.JavaSE.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherDemo {
    public static void main(String[] args) {
        /**
         matches:整个匹配，只有整个字符序列完全匹配成功，才返回True，否则返回False。但如果前部分匹配成功，将移动下次匹配的位置。
         lookingAt:部分匹配，总是从第一个字符进行匹配,匹配成功了不再继续匹配，匹配失败了,也不继续匹配。
         find:部分匹配，从当前位置开始匹配，找到一个匹配的子串，将移动下次匹配的位置。
         reset:给当前的Matcher对象配上个新的目标，目标是就该方法的参数；如果不给参数，reset会把Matcher设到当前字符串的开始处。
         start、end： 若能成功匹配，返回开始匹配的位置和结束位置+1
         group:分组
         appendReplacement:
         appendTail:
         */
        Pattern p = Pattern.compile("\\d{3,5}");
        String s = "123-567-777-00";
        Matcher m = p.matcher(s);
        System.out.println(m.matches());
        /**重置 m.matches 和 find这两个方法会互相影响，需要reset*/
        m.reset();
        /**找子串*/
        System.out.println("--------------------2");
        System.out.println(m.find());
        /**若能成功匹配，返回开始匹配的位置和结束位置+1*/
        System.out.println(m.start() + "-" + m.end());
        System.out.println(m.find());
        System.out.println(m.start() + "-" + m.end());
        System.out.println(m.find());
        System.out.println(m.start() + "-" + m.end());
        System.out.println(m.find());
//        System.out.println(m.start()+"-"+m.end()); //必须匹配才能使用，不然抛异常
        /**每次都从头开始找*/
        System.out.println("-------------------3");
        System.out.println(m.lookingAt());
        System.out.println(m.start() + "-" + m.end());
        System.out.println(m.lookingAt());
        System.out.println(m.start() + "-" + m.end());
        System.out.println(m.lookingAt());
        System.out.println(m.start() + "-" + m.end());
        System.out.println(m.lookingAt());
        System.out.println(m.start() + "-" + m.end());

        /**
         * 字符串替换
         */
        System.out.println("-------------------4");
        Pattern p1 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);//忽略大小写
        Matcher m1 = p1.matcher("sss java java JAVA JaVa JAVa IloveJavA YouhateJaVA ggghhhjkd");
        while (m1.find()) {
            System.out.println(m1.group());
            System.out.println(m1.replaceAll("JAVA"));
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        m1.reset();
        while (m1.find()) {
            i++;
            if (i % 2 == 0) {
                m1.appendReplacement(sb, "java");
            } else {
                m1.appendReplacement(sb, "JAVA");
            }
        }
        m1.appendTail(sb);
        System.out.println(sb.toString());
        /**
         * 分组 group
         */
        System.out.println("-------------------5");
        /**第几个左小括号组号就是几*/
        Pattern p2 = Pattern.compile("(\\d{3,5})([a-z]{2})");
        Matcher m2 = p2.matcher("123aa-345bb-234cc-00");
        while (m2.find()) {
            System.out.println(m2.group());
            System.out.println(m2.group(1));
            System.out.println(m2.group(2));
        }
    }
}
