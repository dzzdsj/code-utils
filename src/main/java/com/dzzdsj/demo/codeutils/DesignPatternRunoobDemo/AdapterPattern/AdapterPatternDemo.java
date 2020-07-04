package com.dzzdsj.demo.codeutils.DesignPatternRunoobDemo.AdapterPattern;

/**
 * 适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁
 * 适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
 * 实现方式：适配器继承或依赖已有的对象，实现想要的目标接口
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
