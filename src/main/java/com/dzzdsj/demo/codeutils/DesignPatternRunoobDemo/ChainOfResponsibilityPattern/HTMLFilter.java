package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.ChainOfResponsibilityPattern;

public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response) {
        String s = request.getRequest().replace("<", "[")
                .replace(">", "]");
        request.setRequest(s);
    }
}
