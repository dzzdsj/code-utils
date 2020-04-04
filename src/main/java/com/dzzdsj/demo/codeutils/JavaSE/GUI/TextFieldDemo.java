package com.dzzdsj.demo.codeutils.JavaSE.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldDemo {
    public static void main(String[] args) {
        new TFFrame();
    }
}

class TFFrame extends Frame{
    public TFFrame() {
        super();
        TextField textField = new TextField();
        textField.addActionListener(new TFActionListener());
        textField.setEchoChar('*');//设置回显字符
        this.add(textField);
        pack();
        this.setVisible(true);
    }
}

class TFActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField textField = (TextField) e.getSource();//获取事情源对象
        System.out.println(textField.getText());
        textField.setText("");
    }
}