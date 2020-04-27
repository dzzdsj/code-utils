package com.dzzdsj.demo.codeutils.DesignPattern.MementoPattern;
//Memento 包含了要被恢复的对象的状态
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
