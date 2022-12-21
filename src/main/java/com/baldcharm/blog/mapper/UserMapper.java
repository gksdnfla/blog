package com.baldcharm.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baldcharm.blog.entity.User;

@Mapper
public interface UserMapper {
    public User getUserByUsername(String username);
}
