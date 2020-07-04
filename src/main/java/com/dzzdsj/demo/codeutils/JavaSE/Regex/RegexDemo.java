package com.dzzdsj.demo.codeutils.JavaSE.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Demo for regular expressions
 * <p>
 * java.util.regex.Matcher
 * java.util.regex.Pattern
 */
public class RegexDemo {
    public static void main(String[] args) {
        /**简单形式 String.matches*/
        System.out.println("ddd".matches("..."));
        /**一般用法*/
        Pattern p = Pattern.compile("[a-z]{3}");
        Matcher m = p.matcher("fgh");
        boolean b = m.matches();
        System.out.println(b);

        /**常用形式示例*/
        /**Greedy quantifiers  贪婪模式
         X?	X, once or not at all
         X*	X, zero or more times
         X+	X, one or more times
         X{n}	X, exactly n times
         X{n,}	X, at least n times
         X{n,m}	X, at least n but not more than m times
         */
        System.out.println("-----------2");
        System.out.println("192.168".matches("\\d{1,3}\\.\\d{1,3}"));
        System.out.println("192.168".matches("[0-2][0-9][0-9]\\.[0-2][0-9][0-9]"));
        System.out.println("".matches("a?"));
        System.out.println("".matches("a*"));
        System.out.println("".matches("a+"));
        /**
         Character classes
         [abc]	a, b, or c (simple class)
         [^abc]	Any character except a, b, or c (negation)
         [a-zA-Z]	a through z or A through Z, inclusive (range)
         [a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)  并集
         [a-z&&[def]]	d, e, or f (intersection)  交集
         [a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)  差集
         [a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)
         */
        System.out.println("-----------3");
        System.out.println("a".matches("[abc]"));
        System.out.println("a".matches("[^abc]"));
        //并集
        System.out.println("g".matches("[a-c[f-z]]"));
        System.out.println("g".matches("[a-c]|[f-z]"));
        System.out.println("g".matches("[[a-c][f-z]]"));
        //交集
        System.out.println("d".matches("[a-d&&[b-f]]"));
        //差集
        System.out.println("d".matches("[a-d&&[^bc]]"));

        /**
         Predefined character classes
         .	Any character (may or may not match line terminators)
         \d	A digit: [0-9]
         \D	A non-digit: [^0-9]
         \h	A horizontal whitespace character: [ \t\xA0\u1680\u180e\u2000-\u200a\u202f\u205f\u3000]
         \H	A non-horizontal whitespace character: [^\h]
         \s	A whitespace character: [ \t\n\x0B\f\r]
         \S	A non-whitespace character: [^\s]
         \v	A vertical whitespace character: [\n\x0B\f\r\x85\u2028\u2029]
         \V	A non-vertical whitespace character: [^\v]
         \w	A word character: [a-zA-Z_0-9]
         \W	A non-word character: [^\w]
         */
        System.out.println("-----------4");
        System.out.println("\\".matches("\\\\"));

        /**
         Boundary matchers  边界处理
         ^	The beginning of a line
         $	The end of a line
         \b	A word boundary   单词边界（空格、特殊字符、换行等）
         \b{g}	A Unicode extended grapheme cluster boundary
         \B	A non-word boundary
         \A	The beginning of the input
         \G	The end of the previous match
         \Z	The end of the input but for the final terminator, if any
         \z	The end of the input
         */
        System.out.println("-----------5");
        System.out.println("hello".matches("^h.*"));//匹配开头
        System.out.println("hello".matches(".*o$"));//匹配结尾
        System.out.println(" \n".matches("^[\\s&&[^\\n]]\\n$"));//匹配空白行(以空白字符开头但不是换行符，随后紧跟换行符结尾)

        System.out.println("-----------6");
    }
}
