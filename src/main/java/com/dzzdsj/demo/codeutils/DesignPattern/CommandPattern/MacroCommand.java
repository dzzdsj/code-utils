package com.dzzdsj.demo.codeutils.DesignPattern.CommandPattern;

import java.util.Iterator;
import java.util.Stack;

/**
 * 多条命令的集合
 */
public class MacroCommand implements Command {
    private Stack commands = new Stack();

    @Override
    public void execute() {
        Iterator iterator = commands.iterator();
        while (iterator.hasNext()) {
            ((Command) iterator.next()).execute();
        }
    }

    //添加命令
    public void append(Command command) {
        //防止将自己添加进去，造成无线循环
        if (command != this) {
            commands.push(command);
        }
    }

    //撤销最后一条命令
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    public void clear() {
        commands.clear();
    }
}
