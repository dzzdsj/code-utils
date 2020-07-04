package com.dzzdsj.demo.codeutils.RedisDemo;

import com.dzzdsj.demo.codeutils.SpringBootDemo.Transactional.entity.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * StringRedisTemplate默认使用stringSerializer
     */
    @GetMapping(value = "/stringRedis", produces = "text/plain;charset=UTF-8")
    public String stringRedis() {
        String s = "中国人";
        stringRedisTemplate.opsForValue().set("test:string", s);
        String result = stringRedisTemplate.opsForValue().get("test:string");
        System.out.println(result);
        return result;
    }

    /**
     * redisTemplate默认使用的是jdk序列化策略JdkSerializationRedisSerializer，需要进行配置以方便使用
     */
    @GetMapping("/defaultSerialize")
    public RedisTestUser defaultSerialize() {
        RedisTestUser redisTestUser = new RedisTestUser();
        redisTestUser.setId(3L);
        redisTestUser.setName("tom");
        System.out.println(redisTestUser);
        redisTemplate.opsForValue().set("test:defaultSerialize", redisTestUser);
        RedisTestUser result = (RedisTestUser) redisTemplate.opsForValue().get("test:defaultSerialize");
        System.out.println(result);
        return result;
        //key:\xAC\xED\x00\x05t\x00\x15test:defaultSerialize
        //value:\xAC\xED\x00\x05sr\x001com.dzzdsj.demo.codeutils.RedisDemo.RedisTestUser\x1E5K\xED\xAC3U\xEF\x02\x00\x02L\x00\x02idt\x00\x10Ljava/lang/Long;L\x00\x04namet\x00\x12Ljava/lang/String;xpsr\x00\x0Ejava.lang.Long;\x8B\xE4\x90\xCC\x8F#\xDF\x02\x00\x01J\x00\x05valuexr\x00\x10java.lang.Number\x86\xAC\x95\x1D\x0B\x94\xE0\x8B\x02\x00\x00xp\x00\x00\x00\x00\x00\x00\x00\x03t\x00\x03tom
    }

    @GetMapping("/customizeSerialize")
//    public RedisTestUser customizeSerialize(){
    public Object customizeSerialize() {
        RedisTestUser redisTestUser = new RedisTestUser();
        redisTestUser.setId(3L);
        redisTestUser.setName("tom");
        System.out.println(redisTestUser);
        redisTemplate.opsForValue().set("test:customizeSerialize", redisTestUser);
//        RedisTestUser result =(RedisTestUser) redisTemplate.opsForValue().get("test:customizeSerialize");
        Object result = redisTemplate.opsForValue().get("test:customizeSerialize");
        System.out.println(result);
        return result;
    }

//    @GetMapping("/test")
//    public String test(){
//        String s = "中国人";
//        return s;
//    }
//    @GetMapping("/testUser")
//    public TestUser testUser(){
//        String s = "中国人";
//        TestUser testUser = new TestUser();
//        testUser.setName(s);
//        return testUser;
//    }
}
