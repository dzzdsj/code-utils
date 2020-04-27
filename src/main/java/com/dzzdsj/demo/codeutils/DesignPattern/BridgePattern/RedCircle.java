package com.dzzdsj.demo.codeutils.DesignPattern.BridgePattern;

//步骤 2
//创建实现了 DrawAPI 接口的实体桥接实现类。
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
