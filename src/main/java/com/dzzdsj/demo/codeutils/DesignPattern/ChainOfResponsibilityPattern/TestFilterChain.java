package com.dzzdsj.demo.codeutils.DesignPattern.ChainOfResponsibilityPattern;

/**
 * 责任链设计模式技巧是定义一个过滤器接口，在接口中定义doFilter方法。由若干实现该接口的具体实现类来构成过滤器链
 */
public class TestFilterChain {
    public static void main(String[] args) {
        String s = "dkjg<skjfsk>ksjfl敏感slj十几个反动顺利开工建设了反动零售价格<jjk>";
        System.out.println("begin:"+s);

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter());

        System.out.println("end:"+s);
    }
}
