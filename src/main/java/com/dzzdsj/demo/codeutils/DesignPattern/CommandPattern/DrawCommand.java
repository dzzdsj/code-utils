package com.dzzdsj.demo.codeutils.DesignPattern.CommandPattern;

import java.awt.*;

/**
 * 绘制一个点的命令
 */
public class DrawCommand implements Command {
    protected Drawable drawable;
    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }


    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
