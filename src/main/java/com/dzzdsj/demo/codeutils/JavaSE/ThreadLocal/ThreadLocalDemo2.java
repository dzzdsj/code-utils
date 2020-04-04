package com.dzzdsj.demo.codeutils.JavaSE.ThreadLocal;

public class ThreadLocalDemo2 {
//    private ThreadLocal<Integer> threadLocal = new ThreadLocal();
    /**
     * get()方法用于获取当前线程的副本变量值。
     * set()方法用于保存当前线程的副本变量值。
     * initialValue()为当前线程初始副本变量值。
     * remove()方法移除当前前程的副本变量值。
     */
    private static ThreadLocal<Integer> threadLocalInt = new ThreadLocal(){
    @Override
    protected Object initialValue() {
        return super.initialValue();
    }
};

    public static void setThreadLocalInt(int value) {
        threadLocalInt.set(value);
    }

    public static int getThreadLocalInt() {
        return threadLocalInt.get();
    }

}
