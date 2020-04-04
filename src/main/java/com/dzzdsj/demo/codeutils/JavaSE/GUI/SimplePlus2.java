package com.dzzdsj.demo.codeutils.JavaSE.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 使用内部类，可以方便的访问包围着它的类的成员变量和成员方法，不需额外传对象的引用。编译后名字为：外部类$内部类.class
 * 可以防止不需要访问的类来访问内部类
 */
public class SimplePlus2 {
    public static void main(String[] args) {
        new SimplePlusFrame().launchFrame();
    }
}

class SimplePlusFrame2 extends Frame{
    TextField textField1, textField2, textField3;//将frame内的组件定义为成员变量
    public void launchFrame()  {
        textField1 = new TextField(10);
        textField2 = new TextField(10);
        textField3 = new TextField(20);
        Button equalButton = new Button("=");
        equalButton.addActionListener(new BtnActionListener2());
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

    class BtnActionListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());
            textField3.setText("" + (num1 + num2));
        }
    }
}

