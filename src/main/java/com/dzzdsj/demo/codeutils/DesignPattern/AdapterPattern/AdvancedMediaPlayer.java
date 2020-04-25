package com.dzzdsj.demo.codeutils.DesignPattern.AdapterPattern;

//更高级的播放器
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
