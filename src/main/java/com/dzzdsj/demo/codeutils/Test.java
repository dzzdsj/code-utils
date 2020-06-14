package com.dzzdsj.demo.codeutils;

import com.dzzdsj.demo.codeutils.Valid.User;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        //vm option ：-XX:+PrintGCDetails  -XX:+PrintCommandLineFlags
        /* -XX:+UseParallelOldGC和-XX:+UseParallelGC结果一样，因为MXBean名字一样，但是实际使用的不一样 */
//        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
//        for (GarbageCollectorMXBean bean : beans) {
//            System.out.println(bean.getName());
//        }
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program" + "ming";
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s1.intern());
        User user1 = new User();
        User user2 = new User();
//        user1.setName("a");
        System.out.println(Objects.equals(user1.getName(),"a"));
        System.out.println(Objects.equals(user1,user2));
        System.out.println(user1.equals(user2));
//        System.out.println(user1.getName().equals("a"));//空指针

        List<Integer> list = new ArrayList<>(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);
        System.out.println(list.size());

    }
}
