package com.baldcharm.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baldcharm.blog.entity.User;

@Mapper
public interface UserMapperDao {
    public User getUserByUsername(String username);
}
