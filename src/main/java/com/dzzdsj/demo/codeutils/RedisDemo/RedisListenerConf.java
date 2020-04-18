package com.dzzdsj.demo.codeutils.RedisDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**配置客户端的订阅频道。实现publish/subscribe模式，消息的订阅、发布*/
@Configuration
public class RedisListenerConf {
    @Bean
    MessageListenerAdapter listenerAdapter(){
        return new MessageListenerAdapter(new MyRedisChannelListener());
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory,
                                            MessageListenerAdapter messageListenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListenerAdapter,new PatternTopic("testTopic"));
        return container;
    }
}
