package com.dzzdsj.demo.codeutils.JavaSE.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 持有对方的引用
 */
public class SimplePlus {
    public static void main(String[] args) {
        new SimplePlusFrame().launchFrame();
    }
}

class SimplePlusFrame extends Frame {
    TextField textField1, textField2, textField3;//将frame内的组件定义为成员变量

    public void launchFrame() {
        textField1 = new TextField(10);
        textField2 = new TextField(10);
        textField3 = new TextField(20);
        Button equalButton = new Button("=");
        equalButton.addActionListener(new BtnActionListener(this));//将整个frame对象的引用传给监听器
        Label plusLabel = new Label("+");
        add(textField1);
        add(plusLabel);
        add(textField2);
        add(equalButton);
        add(textField3);
        pack();
        setLayout(new FlowLayout());
        setVisible(true);
    }
}

class BtnActionListener implements ActionListener {
    Frame frame = null;

    //持有整个frame对象的引用
    public BtnActionListener(Frame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num1 = Integer.parseInt(((SimplePlusFrame) frame).textField1.getText());
        int num2 = Integer.parseInt(((SimplePlusFrame) frame).textField2.getText());
        ((SimplePlusFrame) frame).textField3.setText("" + (num1 + num2));
    }
}