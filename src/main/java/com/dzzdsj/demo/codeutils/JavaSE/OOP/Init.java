package com.dzzdsj.demo.codeutils.JavaSE.OOP;

/**
 * 关于变量的初始化
 */
public class Init {
    //(基本类型和它的包装类)成员变量会自动被初始化成默认值
    private int x;
    //对象类型使用前未初始化也会得到空指针异常
    private Super aSuper;
//    private Super aSuper = new Super();
    private void f(){
        int b;
        //局部变量在被使用前必须被初始化
//        b++;
        aSuper.phone = x;
    }
    public static void main(String[] args) {
        int a = (new Init()).x++;
        System.out.println("a="+a);
        Init m = new Init();
        m.f();  //aSuper = null    空指针

    }
}
