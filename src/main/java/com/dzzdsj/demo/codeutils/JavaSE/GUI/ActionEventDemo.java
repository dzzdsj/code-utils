package com.dzzdsj.demo.codeutils.JavaSE.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 事件和某个监听接口一一对应
 */
public class ActionEventDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("test");
        Button button = new Button("button");
        Monitor monitor = new Monitor();//创建实现了ActionListener接口的实现类
        button.addActionListener(monitor);//注册监听器到组件
//        button.setActionCommand("press");//区分按钮的一种方式
        frame.add(button, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

class Monitor implements ActionListener {
    //事件发生时会调用对应事件的回调函数,并传入包装了事件信息的ActionEvent对象
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button has been pressed");
    }
}