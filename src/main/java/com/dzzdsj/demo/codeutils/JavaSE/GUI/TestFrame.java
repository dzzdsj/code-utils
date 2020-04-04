package com.dzzdsj.demo.codeutils.JavaSE.GUI;

import java.awt.*;

/**
 * 几个重要概念：组件、布局管理器、事件
 */
public class TestFrame {
    public static void main(String[] args) {
//        Frame frame = new Frame("hi");
//        frame.setVisible(true);
//        frame.setSize(200,200);
//        frame.setBackground(Color.BLUE);
        /**能用继承尽量用，可以用自己的成员变量*/
        MyFrame f1 = new MyFrame(100,100,200,200, Color.blue);
    }
}

class MyFrame extends Frame{
    static int id = 0;

    public MyFrame(int x, int y, int w, int h, Color color){
        super("MyFrame" + (id++));
        setBackground(color);
        setLayout(null);
        setBounds(x, y, w, h);
        setVisible(true);
    }
}