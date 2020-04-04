package com.dzzdsj.demo.codeutils.DesignPattern.ChainOfResponsibilityPattern;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    List<Filter> filterList = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
         this.filterList.add(filter);
         return this;
    }

    public String doFilter(String str){
        String s = str;
//        for(Filter filter: filterList){
//            s = filter.doFilter(s);
//        }
        return s;
    }
}
