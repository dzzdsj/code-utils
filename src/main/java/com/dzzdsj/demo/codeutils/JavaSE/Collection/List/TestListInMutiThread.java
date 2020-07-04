package com.dzzdsj.demo.codeutils.JavaSE.Collection.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestListInMutiThread {
    public static void main(String[] args) {
        //获取同步的list
        List syncList = Collections.synchronizedList(new ArrayList());
        //add的时候不需要同步但遍历的时候必须手动同步
        synchronized (syncList) {
            Iterator i = syncList.iterator(); // Must be in synchronized block
            while (i.hasNext()) {
                //foo(i.next());
                System.out.println(i.next());
            }
        }
    }
}
