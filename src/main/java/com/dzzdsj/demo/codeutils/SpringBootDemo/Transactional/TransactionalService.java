package com.dzzdsj.demo.codeutils.SpringBootDemo.Transactional;

import com.dzzdsj.demo.codeutils.SpringBootDemo.Transactional.entity.TestUser;
import com.dzzdsj.demo.codeutils.SpringBootDemo.Transactional.mapper.TestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * 注意点：
 * 1.@Transactional 注解只能应用到 public 可见度的方法上。 如果应用在protected、private或者 package可见度的方法上，
 * 也不会报错，不过事务设置不会起作用。
 * 2、默认情况下，Spring会对unchecked(派生于Error或者RuntimeException)异常进行事务回滚；如果是checked异常则不回滚。
 * 辣么什么是checked异常，什么是unchecked异常
 * java里面将派生于Error或者RuntimeException（比如空指针，1/0）的异常称为unchecked异常，其他继承自java.lang.Exception得异常统称为Checked Exception，如IOException、TimeoutException等
 * 辣么再通俗一点：你写代码出现的空指针等异常，会被回滚，文件读写，网络出问题，spring就没法回滚了
 */
//@Transactional  //checked异常则不回滚
//@Transactional(rollbackFor=Exception.class)  //自定义回滚的异常
//@Transactional(rollbackFor= IOException.class)  //自定义回滚的异常
//@Transactional(noRollbackFor=Exception.class)  //自定义不回滚的异常
@Service
public class TransactionalService {
    @Autowired
    private TestUserMapper testUserMapper;

    public void addUser() throws Exception {
        TestUser testUser = new TestUser();
        testUser.setName("bill");
        testUser.setPhone("12345678911");
        testUserMapper.insertSelective(testUser);
        TestUser testUser2 = new TestUser();
        testUser2.setName("tom");
        testUser2.setPhone("12345678911");
        testUserMapper.insertSelective(testUser2);
//        TestUser testUser3 = new TestUser();
//        testUser3.setId(2);
//        testUser3.setName("tom");
//        testUser3.setPhone("12345678911");
//        testUserMapper.insertSelective(testUser3);

//        throw new Exception();//默认不回滚
        throw new IOException();//默认不回滚
//        int i = 1/0;//默认回滚
    }
}
