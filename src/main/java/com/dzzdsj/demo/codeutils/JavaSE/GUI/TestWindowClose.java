package com.dzzdsj.demo.codeutils.JavaSE.GUI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 使用匿名内部类（局部类）
 * 匿名类只能是内部类
 * 匿名类的两种创建方式--既可以继承父类，也可以实现接口
 */
public class TestWindowClose {
    public static void main(String[] args) {
        Frame frame = new Frame("hi");
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });
    }
}
