package com.dzzdsj.demo.codeutils.RedisDemo;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * 监听器类。实现publish/subscribe模式，消息的订阅、发布
 */
public class MyRedisChannelListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] messageChannel = message.getChannel();
        byte[] messageBody = message.getBody();
        try {
            String content = new String(messageBody, "utf-8");
            String channel = new String(messageChannel, "utf-8");
            System.out.println("get:");
            System.out.println("  content:" + content);
            System.out.println("  channel:" + channel);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
