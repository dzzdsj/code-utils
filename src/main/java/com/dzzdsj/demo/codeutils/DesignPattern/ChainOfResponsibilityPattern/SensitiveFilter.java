package com.dzzdsj.demo.codeutils.DesignPattern.ChainOfResponsibilityPattern;

public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response) {
        String s = request.getRequest().replace("敏感","和谐")
                .replace("反动","和谐");
        request.setRequest(s);
    }
}
