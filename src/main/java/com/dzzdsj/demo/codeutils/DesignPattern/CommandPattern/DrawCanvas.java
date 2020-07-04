package com.dzzdsj.demo.codeutils.DesignPattern.CommandPattern;

import java.awt.*;

// TODO: 2020/6/19  
public class DrawCanvas extends Canvas implements Drawable {
    private Color color = Color.red;

    @Override
    public void draw(int x, int y) {
        Graphics graphics = getGraphics();
        graphics.setColor(color);
//        graphics.fillOval();
    }
}
