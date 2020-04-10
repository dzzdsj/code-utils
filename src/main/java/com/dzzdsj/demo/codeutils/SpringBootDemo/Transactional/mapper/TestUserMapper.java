package com.dzzdsj.demo.codeutils.SpringBootDemo.Transactional.mapper;

import com.dzzdsj.demo.codeutils.SpringBootDemo.Transactional.entity.TestUser;

public interface TestUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    TestUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestUser record);

    int updateByPrimaryKey(TestUser record);
}